name := """azurejay"""

organization := "ru.eis"

version := "0.1"

scalaVersion := "2.10.4"

lazy val buildVersion =  "2.1.0"
lazy val playVersion =  "2.2.3"

// Change this to another test framework if you prefer
libraryDependencies ++= Seq(
  "com.typesafe.play" %% "play" % playVersion % "provided",
  "com.typesafe" %% "play-plugins-util" % buildVersion,
  "org.scalatest" %% "scalatest" % "2.1.6" % "test"
)

scalacOptions += "-deprecation"

javacOptions ++= Seq("-source", "1.6", "-target", "1.6", "-Xlint:unchecked", "-encoding", "UTF-8")

// Uncomment to use Akka
//libraryDependencies += "com.typesafe.akka" % "akka-actor_2.11" % "2.3.3"

