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

  lazy val config = {
    List(
      "OPENSHIFT_NOSQL_DB_HOST",
      "OPENSHIFT_NOSQL_DB_PORT",
      "OPENSHIFT_NOSQL_DB_USERNAME",
      "OPENSHIFT_NOSQL_DB_PASSWORD"
    ) map (env => System.getenv(env))
    match {
      case List(null, null, null, null) => MongoDB.defineDb(DefaultMongoIdentifier, new Mongo, dbName)
      case List(host, port, username, pwd) => MongoDB.defineDbAuth(
        DefaultMongoIdentifier,
        new Mongo(new ServerAddress(host, port.toInt)),
        dbName,
        username,
        pwd
      )
    }
  }
}
