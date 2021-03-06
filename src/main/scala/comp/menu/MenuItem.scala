package comp.menu

import javax.annotation.PostConstruct
import web.view.Environment
import javax.interceptor.InvocationContext

/**
 * Created with IntelliJ IDEA.
 * User: Oleg
 * Date: 31.08.12
 * Time: 1:34
 * To change this template use File | Settings | File Templates.
 */
trait MenuItem {
  val name: String

  @PostConstruct
  def addSelf(ctx: InvocationContext) {
    Environment.registeredNames ::= name
  }
}
