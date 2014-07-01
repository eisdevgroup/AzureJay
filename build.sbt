name := """azurejay"""

version := "0.1"

scalaVersion := "2.10.4"

// Change this to another test framework if you prefer
libraryDependencies ++= Seq(
  "com.typesafe.play" %% "play" % "2.2.3" % "provided",
  "com.typesafe.play.plugins" %% "play-plugins-util" % "2.2.3",
  "org.scalatest" %% "scalatest" % "2.1.6" % "test"
)

scalacOptions += "-deprecation"

javacOptions ++= Seq("-source", "1.6", "-target", "1.6", "-Xlint:unchecked", "-encoding", "UTF-8")

// Uncomment to use Akka
//libraryDependencies += "com.typesafe.akka" % "akka-actor_2.11" % "2.3.3"

