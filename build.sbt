
lazy val root = (project in file(".")).
  // enablePlugins(GitVersioning).
  settings(
    version := "0.1.0-SNAPSHOT",
    organization := "org.scalavista",
    sbtPlugin := true,
    name := "sbt-scalavista",
    description := "sbt plugin to create config file for scalavista",
    scalacOptions := Seq("-deprecation", "-unchecked"),
    libraryDependencies += "io.spray" %%  "spray-json" % "1.3.5"
  )
