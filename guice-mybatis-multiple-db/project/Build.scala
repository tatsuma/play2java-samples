import sbt._
import Keys._
import play.Project._

object ApplicationBuild extends Build {

  val appName         = "guice-mybatis-multiple-db"
  val appVersion      = "1.0"

  val appDependencies = Seq(
    javaCore,
    javaJdbc,
    "org.mybatis" % "mybatis" % "3.2.1",
    "org.mybatis" % "mybatis-guice" % "3.3",
    "mysql" % "mysql-connector-java" % "5.1.18",
    "org.mockito" % "mockito-all" % "1.9.5"
  )

  val main = play.Project(appName, appVersion, appDependencies).settings(
    // Add your own project settings here      
  )

}
