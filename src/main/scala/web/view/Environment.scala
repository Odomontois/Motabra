package web.view

import reflect.BeanProperty
import java.util
import collection.JavaConversions._

/**
 * Created with IntelliJ IDEA.
 * User: odomontois
 * Date: 29.08.12
 * Time: 16:00
 * To change this template use File | Settings | File Templates.
 */
object Environment {
  var registeredNames = List[String]()
}

class Environment {
  @BeanProperty val registeredNames = new util.ArrayList(Environment.registeredNames)
  @BeanProperty val envs = System.getenv.entrySet
}
