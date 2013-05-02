import sbt._
import Keys._
import play.Project._

object ApplicationBuild extends Build {

  val appName         = "custom-routes-type"
  val appVersion      = "1.0-SNAPSHOT"

  val appDependencies = Seq(
    // Add your project dependencies here,
    javaCore,
    javaJdbc
  )

  val main = play.Project(appName, appVersion, appDependencies).settings(
    routesImport += "_root_.utils.Binders._"     
  )

}
