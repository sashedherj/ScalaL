package advScala.lectures.part1_recap

import scala.annotation.tailrec

object recap extends App {

  val acondition: Boolean = false
  val aifExprsn  = if(acondition) 35 else 65

  //statements (c++/java/..) vs expressions(Scala)
  val acodeBlock = {
    if(acondition) 53
    45    //-> last value of code block wil be assigned to the acodeBlock
  }


  //functions
    // @tailrec - converts the tail recurssion code to iterable byte code to run on jvm
    @tailrec def factorial(n:Int, res:Int): Int={
      if(n<=1)  res
      else factorial(n-1,res*n)
    }
    println(factorial(5,1))

  //oops
    class Animal
    class Dog extends Animal
    val aDog:Animal = new Dog()  // object polymorphism  by subtyping

    //interfaces
    trait carnivore {
      def eat(a: Animal): Unit
    }

    class Crocodile extends Animal with carnivore{
      override def eat(a: Animal): Unit = println("eats animal")
    }

    //method notations
     val aCroc = new Crocodile()
      aCroc.eat(aDog)
      aCroc eat aDog  // infix notation - generally all scala operators are onternally converted into dotted notation like 1+2 => 1.+(2) like + as a method in scala

    // anaonymous classes - ex: implemeting trait without even extending to new class, compiler will automatically does that
    val aCrorcAnonymous = new carnivore {
      override def eat(a: Animal): Unit = println("carnivore from anonymous class")
    }

    aCrorcAnonymous.eat(aDog)

  //generics
  abstract class MyList[+A] // type parameter +A, will discuss more later about variance and its problems

    // singleton and companions
    object MyList // comapanion object MyList[+A]

    //case class
    case class person(name:String, age:Int) /* lightweight object that is lightweight ds which has bunch of utilities and
                                                person is serializable  with all feilds has companion methods like apply */

  // exceptions - try/catch/finally
  val aException = try{
    throw new RuntimeException() // returns nothing - void type
  }
  catch
      case e:Exception => "i cought an exception"
  finally
        println("Unrecognized Exception")

  //functional programming - it is basically treating fnuctions as first class objects
  val incrementer = new Function1[Int,Int] {
    override def apply(v1: Int): Int = v1+1
  }
  println(incrementer(1))

    // sugar syntax for incrementer
    val incrementerSugar =  (x:Int) => x+1  // lamda functions HOF
    val listIncrementer = List(1,2,3).map(incrementer)
    println(listIncrementer)
  //MAP, FlatMap, Filter

    // for comprehensions
    val pairs = for{
      num <- List(1,2,3)
      chr <- List("a","b","c")
    } yield num.toString + '-' + chr

    println(pairs)

  // Scala Collections: seq, array, list, vector, map, tuples
  val amap = Map{
    "alice" -> 1
    "bob" -> 2
  }

  // quote-unquote collections for abstract computations - options and try's
  val anOption = Some(2)
  println(anOption)

  //Pattern Matching
    //variable- value match
    val x = 2
    val xmatch = x match{
      case 1 => "Firse"
      case 2 => "Second"
      case _ => "Anything"

    }
    println(xmatch)

    // function signature match
    val bob = new person("bob", 25)
    val greet = bob match{
      case person(s,n) => s"my name is $s and i'm $n yrs old"
      case _ =>s"can be anybody"
    }

    println(greet)

}