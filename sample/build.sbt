name := """sample"""

version := "1.0-SNAPSHOT"

play.Project.playScalaSettings

scalaVersion := "2.10.4"

libraryDependencies ++= Seq(
  "ru.eis" %% "azurejay" % "0.1"
)