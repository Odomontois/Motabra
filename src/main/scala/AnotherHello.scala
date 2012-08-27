import javax.servlet.http.{HttpServletResponse, HttpServletRequest, HttpServlet}

/**
 * Created with IntelliJ IDEA.
 * User: Oleg
 * Date: 28.08.12
 * Time: 0:55
 * To change this template use File | Settings | File Templates.
 */
class AnotherHello extends HttpServlet {
  override def doGet(req: HttpServletRequest, resp: HttpServletResponse) {
    resp.getWriter.println("Ohayo");
  }
}
