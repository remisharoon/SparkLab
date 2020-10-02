name := "SparkLab"

version := "0.1"

//scalaVersion := "2.13.1"

val sparkVersion = "2.4.4"
val monocleVersion = "2.0.3"

libraryDependencies ++= Seq(

  //spark
  "org.apache.spark" %% "spark-core" % sparkVersion,
  "org.apache.spark" %% "spark-streaming" % sparkVersion,
  "org.apache.spark" %% "spark-mllib" % sparkVersion,

  //monocle
  "com.github.julien-truffaut" %% "monocle-core" % monocleVersion,
  "com.github.julien-truffaut" %% "monocle-macro" % monocleVersion

)