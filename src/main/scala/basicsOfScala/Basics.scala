package basicsOfScala

object Basics  extends App { //extends to app to make code runnable as standalone
  //every thing in scala are expressions

  private val age: Int = 25 // similar to declaring the Const value in CPP with val in scala.  const int msg = 25;
  //age = 26  throws an error 'reassignment to val' is illegal
  print(s"age is $age")

  //  Other data types can be  Int, String, Boolean  and optional to specify data type
  private val flg = false
  print(s"$age is not age, $flg")

  //  strings
  val str1 = "I love Scala"
  print(str1)
  print("statement can be : " + str1) // string can be concatenated with another, using '+'
  print(s"Statement can be : $str1") //Referencing string  with var reference - 'Interpolation of strings  with s"" '

  //assigning expression results to variables
  var add = 2 + age
  print(s"his brother age is $add")

  //  Conditional statements
  private var ag = ""
  ag = if (age > 20) "Adult" else "Child"  //assigning  result of if expression to ag variable
  print(ag)

  private val ag1 = { // Conditional Chaining
    if (ag == "Adult") print("Age is greater than 20")
    else if (ag == "Child") print("Age is less than 20")
    else print("Conditional Chaining")
    3                                // 3 will be assigned to the code block $ag1
  }
  print(s"var output from conditional chaining is $ag1")

  //  Code Blocks - are notable expressions in scala
  val codeBlock1 = {
    //we can declare functions or variable with in code blocks
    val x: Int = 24
    print("value of x in code block is " + x)
    x + 2
    //    x+2 will be the last value assigned to entire codeBlock1
  }

  print(s"value of code block is $codeBlock1")


  //Functions in Scala - Scala the functional programming language
  private def basicFunction(x1: Int): Int = {
    val y: Int = 20
    x1 + y
  }

  var y = basicFunction(3)
  print(s"value of y after function call is $y")

  //  Recursive functions - remember  looping is heavily discouraged in scala think in terms of functions and recursive functions
  def factorial(num: Int): Int = {
    if (num == 1) 1
    else num * factorial(num - 1)
  }

  var num = 5
  print(s"factorial of $num  is  " + factorial(num))

  print(print("x+y= z"), print("x= z-y")) // print returns nothing void in other lang, in scala they return unit type

  //  define funtion that returns unit
  def demoReturnsUnit(): Unit = {
    print("Functions returns Unit = ()")
  }

  var demoUnit: Unit = demoReturnsUnit() //demoUnit is assigned to  unit returned by function
  print(demoUnit)
  print(Basics.num)
}
