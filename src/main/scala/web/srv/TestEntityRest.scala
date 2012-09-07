package web.srv

import javax.servlet.http.{HttpServletResponse, HttpServletRequest, HttpServlet}
import web.view.test.{Entry, TestEntities}
import javax.servlet.annotation.WebServlet
import db.util.record.TestEntity
import db.util.MongoConfig

/**
 * Created with IntelliJ IDEA.
 * User: Oleg
 * Date: 06.09.12
 * Time: 21:41
 * To change this template use File | Settings | File Templates.
 */
@WebServlet(name = "TestEntity", urlPatterns = Array("/test/entities"))
class TestEntityRest extends HttpServlet {

  import TestEntityRest._

  override def doGet(req: HttpServletRequest, resp: HttpServletResponse) {
    MongoConfig.config()
    resp.setContentType("text/plain")
    resp.getWriter.print("servlet " + this.getServletName + " is running")

  }

  override def doPut(req: HttpServletRequest, resp: HttpServletResponse) {
    val firstName = req.getParameter(Param.firstName)
    val secondName = req.getParameter(Param.lastName)
    TestEntity
      .firstName(firstName)
      .secondName(secondName)
      .save
  }

  override def doDelete(req: HttpServletRequest, resp: HttpServletResponse) {
    super.doDelete(req, resp)
  }
}

object TestEntityRest {

  object Param {
    val firstName = "firstName"
    val lastName = "lastName"
  }

}
