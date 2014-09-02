name := """azurejay"""

organization := "ru.eis"

version := "0.1.1"

scalaVersion := "2.11.1"

crossScalaVersions := Seq("2.11.1", "2.10.4")

lazy val playVersion =  "2.3.0"

// Change this to another test framework if you prefer
libraryDependencies ++= Seq(
  "com.typesafe.play" %% "play" % playVersion % "provided",
  "com.typesafe.play" %% "play-ws" % playVersion % "provided",
  "org.scalatest" %% "scalatest" % "2.1.6" % "test"
)

scalacOptions += "-deprecation"

javacOptions ++= Seq("-source", "1.7", "-target", "1.7", "-Xlint:unchecked", "-encoding", "UTF-8")

resolvers += "Typesafe repository" at "http://repo.typesafe.com/typesafe/releases/"

publishTo := {
  val artifactory = "http://artifactory.eis.ru/artifactory/"
  if (version.value.trim.endsWith("SNAPSHOT"))
    Some("Artifactory Realm" at artifactory + "libs-snapshot-local/")
  else
    Some("Artifactory Realm" at artifactory + "libs-release-local/")
}

credentials += Credentials(Path.userHome / ".ivy2" / ".credentials")


