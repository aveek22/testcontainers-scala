scalaVersion := "3.1.2"

val scala3Version = "3.1.2"

import Dependencies.*

lazy val root = project
  .in(file("."))
  .configs(IntegrationTest)
  .settings(
      name         := "testcontainers-scala",
      scalaVersion := scala3Version
  )
  // general dependencies from the code template
  .settings(
      libraryDependencies ++= Seq(
          "com.typesafe"                % "config"          % typesafeConfig,
          "io.circe"                   %% "circe-core"      % circe,
          "io.circe"                   %% "circe-generic"   % circe,
          "io.circe"                   %% "circe-parser"    % circe,
          "com.typesafe.scala-logging" %% "scala-logging"   % scalaLogging,
          "ch.qos.logback"              % "logback-classic" % logback,
          "org.scalatest"              %% "scalatest"       % scalatest % "test,it",
          "org.scalatestplus"          %% "mockito-3-4"     % mockito   % Test,
          "com.dimafeng" %% "testcontainers-scala-scalatest" % testContainers % "it",
          "com.dimafeng" %% "testcontainers-scala-kafka"     % testContainers % "it"
      )
  )
  // specific application dependencies
  .settings(
      libraryDependencies ++= Seq(
          "org.apache.kafka" % "kafka-clients" % kafka
      )
  )
