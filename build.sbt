ThisBuild / version := "0.1.2"
ThisBuild / organization := "org.scalavista"
ThisBuild / description := "sbt plugin for generating scalavista config files"

ThisBuild / licenses += ("MIT", url("https://opensource.org/licenses/MIT"))

lazy val root = (project in file(".")).
  settings(
    sbtPlugin := true,
    name := "sbt-scalavista",
    publishMavenStyle := false,
    bintrayRepository := "sbt-plugins",
    bintrayOrganization in bintray := None,
    scalacOptions := Seq("-deprecation", "-unchecked"),
    libraryDependencies += "io.spray" %%  "spray-json" % "1.3.5"
  )
