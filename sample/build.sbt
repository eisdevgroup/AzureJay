import play.Play.autoImport._
import PlayKeys._

name := """sample"""

version := "1.0-SNAPSHOT"

scalaVersion := "2.11.1"

crossScalaVersions := Seq("2.11.1", "2.10.4")

libraryDependencies ++= Seq(
  ws,
  "ru.eis" %% "azurejay" % "0.1.1"
)

lazy val root = (project in file(".")).enablePlugins(PlayScala)