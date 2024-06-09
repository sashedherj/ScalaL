package com.basicsOfScala

import java.lang.Thread
import scala.concurrent.ExecutionContext.Implicits.global  // global is thread pool in scala to run threads
import scala.concurrent.Future
import scala.util.{Failure, Success, Try}

object AdvancedTopics extends  App {

  // Lazy Evaluation - expression doesn't get executed until it has been first used
  lazy val alazy = 2
  lazy val lazywithsideeff = {
    println("It is so lazy to be  evaluated unless val 'lazywithsideeff' is used as rval in any expresion")
    43
  }

  val eager = lazywithsideeff+1     // line 8 executed because it has 'lazywithsideeff' is used in rval in line 12
  println(eager)

  // Pseudo - Collections : option, try, future  sort of collections actually they are monads in functional programming

  // 1.option used to check wheather any function returning null : example  https://stackoverflow.com/questions/49944872/understanding-some-and-option-in-scala
  // option has 2 cases Some or None
  def methodCanRetrunNull():String = "hello, scala"  // replace string with null match case with none in line 23
  val anoption = Option(methodCanRetrunNull())
  val anoptionmatching = anoption match{
    case Some(str) => s" it obtained valid string -> $str"
    case none =>  s"function may return null so to avoid nullpointexception returning None"
  }
  println(anoptionmatching)

  // 2. Try used to check wheather a function returns a succesfull value or raise an runtime exception
  def amethodcanthrowruntimeexception (): String = "no exception"  // replace string with throw new RuntimeException
  val atry = Try(amethodcanthrowruntimeexception())
  val atrymatch = atry match{
    case Success(str) => s"this function raises $str"
    case Failure(exception) => s"this function raise $exception"
  }
  println(atrymatch)


  /*

  Evaluate some thing on another thread - multi threading asynchoronus programming
  using future and Executorcontext

   */

  val asyn = Future({         // we can remove paranthesis and call as future{} because {} is passed as arg to future apply method
    println("Loading ....")
    Thread.sleep(1000)
    println("This execution is done on another thread")
  })

  Thread.sleep(2000)   // sleep more than child process in line 51 othewise main function will exit
  /*

  1. Future is a sort collection  which contains a value when it is evaluated
  2. Future is composable with map, flatmap, filter
  IMP: Future, Try, Options are actually monads  in functional programming

   */

  // Implicts basics
  // 1. Implicit arguments
  def amethodtakesimplictargs(implicit arg:Int) = arg +1
  implicit  val avar: Int = 46
  print(amethodtakesimplictargs)  // similar to amethodtakesimplictargs(avar) by default it takes the  implicit variable

  // 2. Implicit Conversion
   implicit class MyRichInteger(n:Int){  // this class takes the integer and wraps an interger class into my class MyRichInteger
    def isEven() = n%2==0
  }

  println(23.isEven())  // compiler 1st checks wheater isEven method is available in integer class if not it check wheather any inplict class is defined or not
  // 23.isEven()   ~   new MyRichInteger(23).isEven()

}
