name := "slides"

scalaVersion := "2.10.1"

resolvers += "Typesafe Snapshots" at "http://repo.typesafe.com/typesafe/snapshots/"

libraryDependencies ++= Seq(
  "org.scalaz" %% "scalaz-core" % "7.0.0-M9"
)

scalacOptions ++= Seq("-feature", "-deprecation")
