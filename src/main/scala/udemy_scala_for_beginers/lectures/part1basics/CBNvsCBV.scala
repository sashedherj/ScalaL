package  udemy_scala_for_beginers.lectures.part1basics

object CBNvsCBV extends App {

  /*
  Call by value:
  •value is computed before call
  •same value used everywhere
 
  Call by name:
  •expression is passed literally
  •expression is evaluated at every use within
 
   */

  def calledByValue(x: Long): Unit = { // call by value actually evaluates the if parameter exprsn before passing as a paramenter
    println("by value: " + x)
    println("by value: " + x)
  }

  def calledByName(x: => Long): Unit = { // '=>' call by name replaces the actual parameter with exprsn it passed as parameter where it is used in funtion
    println("by name: " + x)
    println("by name: " + x)
  }

  calledByValue(1257387745764245L)
  calledByName(System.nanoTime()) //  x is replaced by System.nanoTime() whereever it is used in calledByName function (=>x)

  def infinite(): Int = 1 + infinite()

  def printFirst(x: Int, y: => Int) = println(x)

  //  printFirst(infinite(), 34) // stack overflow
  printFirst(34, infinite()) // '=>' evaluates as lazy only when it is used because =>infinate() never been reached to base case
}
