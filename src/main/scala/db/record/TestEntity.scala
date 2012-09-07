package db.util.record

import net.liftweb.mongodb.record.{MongoMetaRecord, MongoRecord}
import net.liftweb.record.field.StringField
import db.util.MongoConfig

/**
 * Created with IntelliJ IDEA.
 * User: Oleg
 * Date: 06.09.12
 * Time: 20:08
 * To change this template use File | Settings | File Templates.
 */
class TestEntity private() extends MongoRecord[TestEntity] {
  def meta = {
    MongoConfig.config
    TestEntity
  }

  def id = firstName.is + " " + secondName.is

  object firstName extends StringField(this, 0)

  object secondName extends StringField(this, 0)

}

object TestEntity extends TestEntity with MongoMetaRecord[TestEntity] {
}
