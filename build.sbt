name := "Layout"

version := "1.0"

scalaVersion := "2.11.6"

resolvers += "Typesafe Releases" at "http://repo.typesafe.com/typesafe/maven-releases/"

libraryDependencies ++= {
  Seq(
    "org.scalatest"         %% "scalatest"          % "2.2.4"       % "test"
  )
}
    