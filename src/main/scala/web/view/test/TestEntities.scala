package web.view.test

import reflect.BeanProperty
import collection.JavaConversions._
import db.util.record.TestEntity
import db.util.record.TestEntity.firstName

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
  def entities: List[Entry] = TestEntity.findAll.map(
    entity => Entry(
      firstName = entity.firstName.is,
      lastName = entity.secondName.is,
      mongoId = entity.id.value
    ))
}

case class Entry(@BeanProperty val firstName: String,
                 @BeanProperty val lastName: String,
                 @BeanProperty val mongoId: String)

