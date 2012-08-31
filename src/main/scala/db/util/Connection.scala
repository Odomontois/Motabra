package db.util

import com.mongodb.casbah.MongoConnection
import reflect.BeanProperty
import java.util

/**
 * Created with IntelliJ IDEA.
 * User: Oleg
 * Date: 29.08.12
 * Time: 0:21
 * To change this template use File | Settings | File Templates.
 */

object Connection{


  def apply() =  {
    (System.getenv("OPENSHIFT_NOSQL_DB_HOST"), System.getenv("OPENSHIFT_NOSQL_DB_PORT")) match{
      case (null,null) => MongoConnection()
      case (host,port)  => MongoConnection(host,port.toInt)
    }
  }
}
class Connection{

  @BeanProperty
  val mongo = Connection()
  @BeanProperty
  val version = mongo.version
}
