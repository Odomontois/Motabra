package web.view.test

import reflect.BeanProperty
import collection.JavaConversions._

/**
 * Created with IntelliJ IDEA.
 * User: Oleg
 * Date: 06.09.12
 * Time: 21:19
 * To change this template use File | Settings | File Templates.
 */
class TestEntities {

  type JCollection[T] = java.util.Collection[T]


  @BeanProperty
  val entities: JCollection[Entry] = TestEntities.entities

}

object TestEntities {
  var entities = List(Entry("Тестовый", "Чувак"))
}

case class Entry(@BeanProperty val firstName: String,
                 @BeanProperty val lastName: String)

