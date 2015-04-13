scalaVersion := "2.11.6"

libraryDependencies ++= Seq(
  "org.scala-lang" % "scala-compiler" % "2.11.6" % Compile,
  "org.scalaz" %% "scalaz-core" % "7.1.0"
)


initialCommands in console :=
  """|import scalaz._
     |import Scalaz._
     |
     |val repl = REPLesent(input="presentation.txt",intp=$intp)
     |import repl._
     """.stripMargin

shellPrompt := { state =>
   import scala.Console.{CYAN,RESET}
   val p = Project.extract(state)
   val name = p.getOpt(sbt.Keys.name) getOrElse p.currentProject.id
   s"[$CYAN$name$RESET] $$ "
}
