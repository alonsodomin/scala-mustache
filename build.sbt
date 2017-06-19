name := "mustache"

scalaVersion in ThisBuild := "2.11.11"

version in ThisBuild := "1.2"

lazy val sharedSettings = Seq(
  name := "mustache",
  resolvers ++= Seq(
    "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/",
    "Typesafe Snapshots Repository" at "http://repo.typesafe.com/typesafe/snapshots/"
  )
)

lazy val mustache = (crossProject(JVMPlatform, NativePlatform) in file("."))
    .settings(sharedSettings)
    .jvmSettings(
      libraryDependencies ++= Seq(
        "junit" % "junit" % "4.8.1" % "test->default",
        "org.specs2" %% "specs2" % "2.3.12" % "test->default",
        "com.typesafe.akka" %% "akka-actor" % "2.3.3" % "test->default"
      )
    )

lazy val mustacheJVM = mustache.jvm
lazy val mustacheNative = mustache.native
