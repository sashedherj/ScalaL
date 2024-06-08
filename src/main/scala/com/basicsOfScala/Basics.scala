package com.basicsOfScala

object Basics  extends App { //extends to app to make code runnable as standalone
  private val age: Int = 25 // similar to declaring the Const value in CPP with val in scala.  const int msg = 25;
  //age = 26  throws an error 'reassignment to val' is illegal
  println(s"age is $age")

  //  Other data types can be  Int, String, Boolean  and optional to specify data type
  private val flg = false
  println(s"$age is not age, $flg")

  //  strings
  val str1 = "I love Scala"
  println(str1)
  println("statement can be : " + str1) // string can be concatenated with another, using '+'
  println(s"Statement can be : $str1") //Referencing string  with var reference - 'Interpolation of strings  with s"" '

  //assigning expression results to variables
  var add = 2 + age
  println(s"his brother age is $add")

  //  Conditional statements
  private var ag = ""
  ag = if (age > 20) "Adult" else "Child"  //assigning  result of if expression to ag variable
  println(ag)

  private val ag1 = { // Conditional Chaining
    if (ag == "Adult") println("Age is greater than 20")
    else if (ag == "Child") println("Age is less than 20")
    else print("Conditional Chaining")
    3                                // 3 will be assigned to the code block $ag1
  }
  println(s"var output from conditional chaining is $ag1")

  //  Code Blocks
  val codeBlock1 = {
    //we can declare functions or variable with in code blocs
    val x: Int = 24
    println("value of x in code block is " + x)
    x + 2
    //    x+2 will be the last value assigned to codeBlock1
  }

  println(s"value of code block is $codeBlock1")


  //Functions in Scala
  private def basicFunction(x1: Int): Int = {
    val y: Int = 20
    x1 + y
  }

  var y = basicFunction(3)
  println(s"value of y after function call is $y")

  //  Recurrsive functions
  def factorial(num: Int): Int = {
    if (num == 1) 1
    else num * factorial(num - 1)
  }

  var num = 5
  println(s"factorial of $num  is  " + factorial(num))

  println(println("x+y= z"), println("x= z-y")) // println returns nothing void in other lang, in scala they return unit

  //  define funtion that returns unit
  def demoReturnsUnit(): Unit = {
    println("Functions returns Unit = ()")
  }

  var demoUnit: Unit = demoReturnsUnit() //demoUnit is assigned to  unit returned by function
  println(demoUnit)
  println(Basics.num)
}
