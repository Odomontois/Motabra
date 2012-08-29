package web.view

import reflect.BeanProperty

/**
 * Created with IntelliJ IDEA.
 * User: odomontois
 * Date: 29.08.12
 * Time: 16:00
 * To change this template use File | Settings | File Templates.
 */
class Environment {
  @BeanProperty val envs = System.getenv.entrySet
}
