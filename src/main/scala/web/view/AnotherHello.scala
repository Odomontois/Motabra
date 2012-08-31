package web.view

import javax.servlet.http.{HttpServletResponse, HttpServletRequest, HttpServlet}
import scala.collection.JavaConversions._
import javax.servlet.annotation.WebServlet

/**
 * Created with IntelliJ IDEA.
 * User: Oleg
 * Date: 28.08.12
 * Time: 0:55
 * To change this template use File | Settings | File Templates.
 */

class AnotherHello extends HttpServlet {
  override def doGet(req: HttpServletRequest, resp: HttpServletResponse) {
    val x = "Привет"
    resp.setContentType("text/plain")
    resp.setCharacterEncoding("UTF-8")
    for (item <- System.getenv.entrySet()) {
      resp.getWriter.println()
      resp.getWriter.println("%s : %s".format(item.getKey, item.getValue))
    }

  }
}
