import org.apache.logging.log4j.core.config.composite.MergeStrategy
import sun.security.tools.PathList

name := "CommandLineTool"

version := "0.1"

scalaVersion := "2.12.8"

libraryDependencies += "org.skife.com.typesafe.config" % "typesafe-config" % "0.3.0"


libraryDependencies += "com.github.haifengl" %% "smile-scala" % "2.3.0"


libraryDependencies += "org.scalatest" %% "scalatest" % "3.1.1" % "test"


libraryDependencies += "ch.qos.logback" % "logback-classic" % "1.2.3"


libraryDependencies += "com.typesafe.scala-logging" %% "scala-logging" % "3.9.2"



