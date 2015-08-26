name := "user"

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
  javaJdbc,
  javaEbean,
   "org.postgresql" % "postgresql" % "9.3-1102-jdbc41",
  cache
)     

play.Project.playJavaSettings
