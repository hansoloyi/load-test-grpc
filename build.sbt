val projectName = "grpc-scala"

name := projectName

shellPrompt in ThisBuild := { state => s"${Project.extract(state).currentRef.project}-${version.value}> " }

scalacOptions in ThisBuild ++= Seq(
  "-deprecation",
  "-feature",
  "-unchecked",
  "-Xlint:_",
  "-Ywarn-adapted-args",
  "-Ywarn-inaccessible",
  "-Ywarn-infer-any",
  "-Ywarn-nullary-override",
  "-Ywarn-nullary-unit",
  "-Ywarn-numeric-widen",
  "-Ywarn-unused",
  "-Ywarn-unused-import")

lazy val credentialsVal =
  sys.env.get("SEMAPHORE").orNull match {
    case "true" => Credentials(Path.userHome / "ivy_credentials")
    case _ => Credentials(Path.userHome / ".ivy2" / ".credentials")
  }

lazy val commonSettings = Seq(
  updateOptions := updateOptions.value.withCachedResolution(true),

  publishTo := {
    val nexus = "https://videoamp.jfrog.io/videoamp/"
    if (isSnapshot.value)
      Some("snapshots" at nexus + "snapshot")
    else
      Some("releases" at nexus + "release")
  },

  mainClass in Compile := Some("com.videoamp.audience_sizing.ExampleServer"),

  publishArtifact in Test := false,

  parallelExecution in Test := false,
  fork in Test := true,

  organization := "com.videoamp",
  scalaVersion := "2.11.11",

  credentials += credentialsVal,

  resolvers += "vamp release repo" at "https://videoamp.jfrog.io/videoamp/release/",
  resolvers += "vamp snapshot repo" at "https://videoamp.jfrog.io/videoamp/snapshot/",
  resolvers += "vamp test repo" at "https://videoamp.jfrog.io/videoamp/test",
  resolvers += Resolver.sonatypeRepo("public"),
  resolvers += "clojars.org" at "https://clojars.org/repo/",
  resolvers += "central" at "http://repo1.maven.org/maven2",
  resolvers += Resolver.jcenterRepo
)

libraryDependencies ++= Dependencies.cleanroomApiProtobufs
libraryDependencies ++= Dependencies.grpc
libraryDependencies ++= Dependencies.kube

assemblyMergeStrategy in assembly := {
  case "META-INF/io.netty.versions.properties" => MergeStrategy.first
  case PathList("io", "netty", xs @ _*) => MergeStrategy.first
  case n if n.startsWith("META-INF/MANIFEST.MF") => MergeStrategy.discard
  case _ => MergeStrategy.first
}

lazy val root = Project(id = projectName,
  base = file(".")
).settings(commonSettings)
