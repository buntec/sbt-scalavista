package sbtscalavista

import java.io._
import spray.json._
import DefaultJsonProtocol._ // if you don't supply your own Protocol (see below)

import sbt._
import sbt.Keys._

object ScalavistaPlugin extends AutoPlugin {
  // by defining autoImport, the settings are automatically imported into user's `*.sbt`
  object autoImport {
    // configuration points, like the built-in `version`, `libraryDependencies`, or `compile`
    lazy val generateScalavistaConfig = taskKey[Unit]("generates scalavista.json")

    // default values for the tasks and settings
    lazy val baseScalavistaSettings: Seq[Def.Setting[_]] = Seq(
      generateScalavistaConfig := {
        GenerateConfig(sources.value, dependencyClasspath.value, scalaBinaryVersion.value)
      }
    )
  }

  import autoImport._
  override def requires = sbt.plugins.JvmPlugin

  // This plugin is automatically enabled for projects which are JvmPlugin.
  override def trigger = allRequirements

  // a group of settings that are automatically added to projects.
  override val projectSettings =
    inConfig(Compile)(baseScalavistaSettings) ++
    inConfig(Test)(baseScalavistaSettings)
}

object GenerateConfig {
  def apply(sources: Seq[File], classpath: Seq[Attributed[File]], scalaBinaryVersion: String): Unit = {
    val json = JsObject("classpath" -> classpath.map(_.data).mkString(":").toJson,
    "sources" -> sources.map(_.toString).toJson,
    "scalaBinaryVersion" -> scalaBinaryVersion.toJson).prettyPrint
    val file = new File("scalavista.json")
    val bw = new BufferedWriter(new FileWriter(file))
    bw.write(json)
    bw.close()
  }
}
