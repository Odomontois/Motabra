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
@Singleton
@Startup
class MongoConfig {
  val dbName = "test"

  @PostConstruct
  def addSelf(ctx: InvocationContext) {
    MongoDB.defineDb(DefaultMongoIdentifier,
      (System.getenv("OPENSHIFT_NOSQL_DB_HOST"), System.getenv("OPENSHIFT_NOSQL_DB_PORT")) match {
        case (null, null) => new Mongo()
        case (host, port) => new Mongo(new ServerAddress(host, port.toInt))
      },
      dbName)
  }
}
