package db.util

import com.mongodb.casbah.MongoConnection

/**
 * Created with IntelliJ IDEA.
 * User: Oleg
 * Date: 29.08.12
 * Time: 0:21
 * To change this template use File | Settings | File Templates.
 */
object Connection{
  def appply =  {
    System.getenv()
    MongoConnection()
  }
}
