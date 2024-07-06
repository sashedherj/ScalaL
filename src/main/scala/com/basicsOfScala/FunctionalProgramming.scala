package com.basicsOfScala

object FunctionalProgramming extends  App {
  /*
  - Functional Programming
      - compose Functions
      - pass functions as args
      - return functions results
  - Scala runs on a JVM, So JVM does not treat functions as a 1st class elements like objects in object-oriented programming
  -  So how to implement a funtions as 1st class elements on JVM,

   Solution -> FunctionX using Traits
   FunctionX - Function1 Function2 ... ... Function22.    22 is the maximum number of arguments you can pass to the scala functions
   */

  // valueIncreamenter function  take  one integer and returns one integer
  val valueIncrementer = new Function1[Int, Int] {
    override def apply(arg1:Int) :Int =  arg1 +1
  }
  // valueIncrementer.apply(20) //  valueIncrementer.apply(20) is same as valueIncrementer(20)
  print(valueIncrementer(20))

  // stringConcatenator function2 takes 2 strings and return 1 string
  val stringConcatenator = new ((String,String) => String){
    override def apply(v1: String, v2: String): String = v1 + v2
  }
  print(stringConcatenator("I Love"," Scala"))

  // Syntax Sugars
  /*
    val function_name = Function2(String,String,String) {
      override def apply(v1:String, v2:String): String = v1+v2

    //which is same as
    val function_name : ((String,String) => String){
      override def apply(v1: String, v2: String): String = v1 + v2
    }

    //which is same as
      val function_name : ((String,String) => String) = (v1: String, v2: String) => v1 + v2

    // which is same as
      val function_name = (v1: String, v2: String) => v1 + v2
   */

  val function_name_syn_sugars = (v1: String, v2: String) => v1 < v2      // composing functions as syntax sugars
  print(function_name_syn_sugars("One", "Two"))

// Higher Order Functions - which take functions as agrs or returns functions or both
  //  1. map in List type is a Higher Order function
  val modifList = List(1,2,3).map(valueIncrementer)  // same as List(1,2,3).map(x=> x+1) using syntax sugars where x=> x+1 is a anonymous function
  print(modifList)

  // 2. flatnmap
  val flatedMap = List(1,2,3).flatMap(x => List(x, 2*x)) // flat map converts ((1,2),(2,4),(3,6)) => (1,2,2,4,3,6)
  print(flatedMap)
  //alternative syntax for HOF
  /*
    val flatedMap = List(1,2,3).flatMap{x =>
        List(x, 2*x)
    }
   */


  // 3. filter
  val filteredList = List(1,2,3,4,5).filter(x=> x<=3) // x=> x<3 anonymous funtions filter values  less than 3
                                        // ( _<3) shoter syntax which is same as x => x<3
  print(filteredList)

  // in Scala as we work with immutable objects all three map,flatmap, filter return another instance of list so we can chain all these Higher order functions
  // create all the combinaitons of 1,2,3 with all letters of a,b,c using chain of all the HOF used so far
  val allCombinations = List(1,2,3).flatMap(number => List('a','b','c').map(letter => s"$number-$letter"))
  print(allCombinations)

  // for comprehension - human readable syntax for chaining of expresions
  val allCombinationsV2 = for{
    number <- List(1,2,3)
    letter <- List('a','b','c')
  } yield s"$number - $letter"
  print(allCombinationsV2)   // allCombinations, allCombinationsV2 expressions are identical to compiler

  // Collections in Scala
  /*
   1. List
   2. Sequnece
   3. Vector - useful in retriving large datasets
   4. Sets
   5. Ranges
   6. Tuples - grouping single bits of information under single value
   7. Map
   */

  // List
  val aList = List(1,2,3)   // similar to List.apply(1,2,3) - apply companion method on List
  val ahead = aList.head   // head = 1
  val atail = aList.tail   // tail = List(2,3)
  val aPrependList  = 0 :: aList // 0 is prepended to aList
  val appendList = 0 +: aList :+ 4 // +: will prepend to list and :+ will append to list
  print(ahead, atail, aPrependList,appendList)

  // Sequence
  val aseq: Seq[Int] = Seq(1,2,3) // similar to Seq.apply(1,2,3) , where Seq is trait
  print(aseq(1))    // aseq.apply(1)

  // Vector - faster seq implementation
  val avector:Vector[Int] = Vector(1,2,3,4,5)
  print(avector)

  // Sets
  val aset: Set[Int] = Set(1,2,3,1,3)
  print(aset)
  print(aset + 4)  // adding 4 set
  print(aset - 3)  //  removing 3 from set (+, - are methods from set)

  // Ranges
  val arange: Range = 1 to 10
  print(arange)
  val twotimes = arange.map(_*2).toList
  print(twotimes)

  // Tuplees
  val atuple = ("str1", aList, 100)
  print(atuple) //  group of information is tagged to value - atuple

  // Map - key value association
  val amap : Map[String,Int] = Map(
    ("friend1", 234212),
    "friend2" -> 897234  // same as tuple usage ("friend2" , 897234)
  )
}
