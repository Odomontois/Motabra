package db.util

import javax.ejb.{Singleton, Startup}
import javax.annotation.PostConstruct
import javax.interceptor.InvocationContext
import net.liftweb.mongodb.{DefaultMongoIdentifier, MongoDB}
import com.mongodb.{ServerAddress, Mongo}

/**
 * Created with IntelliJ IDEA.
 * User: Oleg
 * Date: 06.09.12
 * Time: 20:45
 * To change this template use File | Settings | File Templates.
 */
object MongoConfig {
  val dbName = "test"
  val openShiftUserName = "test"
  val openShiftPassword = "upparas"
  lazy val configure = config()

  def config() = {
    List(
      "OPENSHIFT_NOSQL_DB_HOST",
      "OPENSHIFT_NOSQL_DB_PORT"
    ) map (env => System.getenv(env))
    match {
      case List(null, null) => {
        MongoDB.defineDb(DefaultMongoIdentifier, new Mongo, dbName)
        "ok"
      }
      case List(host, port) => {
        try {
          MongoDB.defineDbAuth(
            DefaultMongoIdentifier,
            new Mongo(new ServerAddress(host, port.toInt)),
            dbName,
            openShiftUserName,
            openShiftPassword
          )
          List(host, port) toString()
        }
        catch {
          case ex: Exception => List(host, port).toString() + ex.getMessage
        }
      }
      case _ => throw new MongoConfigException
    }
  }
}

class MongoConfigException extends Exception
