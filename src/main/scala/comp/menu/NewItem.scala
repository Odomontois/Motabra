package comp.menu

import javax.ejb.{Startup, Singleton}

/**
 * Created with IntelliJ IDEA.
 * User: Oleg
 * Date: 31.08.12
 * Time: 1:24
 * To change this template use File | Settings | File Templates.
 */

object NewItem {

}

@Singleton
@Startup
class NewItem extends MenuItem {
  val name = "NewItem"

  //  @PostConstruct
  //  def addSelf {
  //    Environment.registeredNames ::= NewItem.name
  //  }
}
