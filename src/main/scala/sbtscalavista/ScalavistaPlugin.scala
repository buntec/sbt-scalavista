package sbtscalavista

import spray.json._
import DefaultJsonProtocol._ // if you don't supply your own Protocol (see below)

import sbt._
import sbt.Keys._
import sbt.IO

object ScalavistaPlugin extends AutoPlugin {

  private val filter = ScopeFilter(inAnyProject, inAnyConfiguration) // this is needed for multi-project builds

  // by defining autoImport, the settings are automatically imported into user's `*.sbt`
  object autoImport {
    // configuration points, like the built-in `version`, `libraryDependencies`, or `compile`
    lazy val generateScopedScalavistaConfig = taskKey[Unit]("generates a scalavista.json")
    lazy val generateScalavistaConfig = taskKey[Unit]("generates a single scalavista.json by merging all subprojects and configurations.")

    // default values for the tasks and settings
    lazy val baseScalavistaSettings: Seq[Def.Setting[_]] = Seq(
      generateScopedScalavistaConfig := {
        GenerateConfig(sources.value, dependencyClasspath.value, scalaBinaryVersion.value, scalacOptions.value)
        },
      generateScalavistaConfig := {
        GenerateConfig((sources ?? Nil).all(filter).value.flatten, (dependencyClasspath ?? Nil).all(filter).value.flatten, scalaBinaryVersion.value, scalacOptions.value)
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

  def apply(sources: Seq[File], classpath: Seq[Attributed[File]], 
            scalaBinaryVersion: String, scalacOptions: Seq[String]): Unit = {

    val json = JsObject(
      "classpath" -> classpath.map(_.data.toString).distinct.toJson,
      "sources" -> sources.map(_.toString).distinct.toJson,
      "scalaBinaryVersion" -> scalaBinaryVersion.toJson,
      "scalacOptions" -> scalacOptions.toJson
      ).prettyPrint

    val file = new File("scalavista.json")
    IO.write(file, json)

  }

}
