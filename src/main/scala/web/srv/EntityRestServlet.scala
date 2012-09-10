package web.srv

import javax.servlet.http.{HttpServletResponse, HttpServletRequest, HttpServlet}
import net.liftweb.record.MetaRecord
import java.io.{InputStream, Reader}
import net.liftweb.http.BadGatewayResponse
import net.liftweb.mongodb.record.{MongoMetaRecord, MongoRecord}
import net.liftweb.json._

/**
 * Created with IntelliJ IDEA.
 * User: odomontois
 * Date: 10.09.12
 * Time: 10:50
 * To change this template use File | Settings | File Templates.
 */
class EntityRestServlet[RecordType <: MongoRecord[RecordType]](entityMeta: MongoMetaRecord[RecordType]) extends HttpServlet {

  import ReaderUtils._

  override def doPost(req: HttpServletRequest, resp: HttpServletResponse) {
    def postOne(obj: JObject) = List(entityMeta fromJValue (obj) openOr (throw new BadRequestException) save) map (_ asJValue);
    def postMany(list: List[JValue]): List[JValue] = list flatten ({
      case JArray(values) => postMany(values)
      case obj: JObject => postOne(obj)
    })
    resp.getWriter.println(
      render(
        JArray(
          parse(req.getInputStream) match {
            case JArray(array) => postMany(array)
            case obj: JObject => postOne(obj)
          })))
  }

  override def doPut(req: HttpServletRequest, resp: HttpServletResponse) {
    entityMeta.fromJSON(req.getInputStream) openOr (throw new BadRequestException) save
  }

  override def doDelete(req: HttpServletRequest, resp: HttpServletResponse) {
    entityMeta.find(req.getInputStream) openOr (throw new NotFoundException) delete_!
  }

  override def doGet(req: HttpServletRequest, resp: HttpServletResponse) {
    resp.getWriter.print(
      render(
        JArray(
          (parse(req.getInputStream) match {
            case qry: JObject => entityMeta.findAll(qry)
            case _ => throw new BadRequestException
          }) map (_ asJValue))))

  }
}

object ReaderUtils {
  implicit def inputStreamToString(istream: InputStream): String =
    scala.io.Source.fromInputStream(istream).toString()
}

class BadRequestException extends Exception

class NotFoundException extends Exception
