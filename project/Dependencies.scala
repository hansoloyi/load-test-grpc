import com.trueaccord.scalapb.compiler.Version.scalapbVersion
import sbt._

object Dependencies {

  val nettyVersion = "1.9.1"

  val cleanroomApiProtobufs = Seq(
    "com.videoamp" %% "cleanroom-api-protobufs" % "1.2.2-SNAPSHOT"
      exclude("com.google.api.grpc", "googleapis-common-protos")
  )

  val grpc = Seq(
    "io.grpc" % "grpc-netty"    % nettyVersion,
    "io.grpc" % "grpc-services" % nettyVersion,
    "io.grpc" % "grpc-protobuf" % nettyVersion,
    "io.grpc" % "grpc-stub" % nettyVersion
  )

  val kube = Seq(
//    "io.skuber" %% "skuber" % "2.0.9",
    "io.kubernetes" % "client-java" % "2.0.0"
  )

//  val netty = Seq(
//    "io.netty" % "netty-transport" % sparkNettyVersion,
//    "io.netty" % "netty-buffer" % sparkNettyVersion,
//    "io.netty" % "netty-common" % sparkNettyVersion
//    // "io.netty" % "netty-codec-http2" % sparkNettyVersion
//    // "io.netty" % "netty-handler-proxy" % sparkNettyVersion
//  )
//
//  val videoampSparkUtils = Seq(
//    "com.videoamp" %% "spark-util" % "3.0.0"
//      exclude("net.minidev", "json-smart")
//  )
//
//  val videoampEtlHelpers = Seq(
//    "com.videoamp" % "etl-aws_2.11" % "3.0.2"
//  )
//
//  val videoampRoaringBitmap = Seq(
//    "com.videoamp" % "RoaringBitmap" % "0.6.28"
//  )
//
//  val jackson = Seq(
//    "com.fasterxml.jackson.core" % "jackson-annotations" % jacksonVersion,
//    "com.fasterxml.jackson.core" % "jackson-core" % jacksonVersion,
//    "com.fasterxml.jackson.core" % "jackson-databind" % jacksonVersion,
//    "com.fasterxml.jackson.module" %% "jackson-module-scala" % jacksonVersion
//  )
//
//  val json4sInSpark = Seq(
//    "org.json4s" %% "json4s-jackson" % json4sVersionInSpark
//  )
//
//  val scalapb = Seq(
//    "com.trueaccord.scalapb" %% "compilerplugin" % "0.6.7",
//    "com.videoamp" %% "scalapb-json4s-shaded" % "1.0.0",
//    "com.trueaccord.scalapb" %% "scalapb-runtime" % scalapbVersion % "protobuf"
//  )
//
//  val test = Seq(
//    "org.scalatest" %% "scalatest" % "3.0.4" % "test"
//  )
//
//  val apacheCommonsIO = Seq(
//    "org.apache.commons" % "commons-io" % "1.3.2"
//  )
//
//  val spark = Seq(
//    "org.apache.spark" %% "spark-core" % sparkVersion
//      exclude("com.typesafe", "config"),
//    "org.apache.spark" %% "spark-hive" % sparkVersion
//  )
//
//  val logging = Seq(
//    "com.typesafe.scala-logging" %% "scala-logging" % "3.9.0"
//  )
//
//  val config = Seq(
//    "com.typesafe" % "config" % "1.3.1"
//  )
}
