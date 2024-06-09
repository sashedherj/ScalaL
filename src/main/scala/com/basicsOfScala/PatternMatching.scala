package com.basicsOfScala

object PatternMatching extends App {

  // Pattern Matching is similar to switch statement in other languages
  val ainteger = 1
  val pattExp = ainteger match {
    case 1 => "First"
    case 2 => "Second"
    case 3 => "Third"
    case _ => "deafult case " + ainteger + "th"
  }
  println(pattExp)

  // pattExp is expression

  // Pattern Matching is useful in decomposing case classes
  case class person(name: String, age: Int)
  val bob = person("bob",43)          // new keyword is not required to instantiate case classes because it has companion object with apply method
  val personGreet = bob match{
    case person(name,age) => s"my name is $name and my age is $age"
    case _ => "pattern does't match with any thing"
  }
  println(personGreet)

  // pattern matching  in tuple
  val atuple = ("Ban Jovi", "Rock")
  val matchtuple = atuple match{
    case (band, genre) => s"$band belongs to genre $genre"
    case _ => "doesn't belongs to any band"
  }

  println(matchtuple)

  // Pattern Matching in list
  val alist = List(1,2,3)
  val listmatch = alist match {
    case List(_, 2, _) => s" This list has 2nd element as 2"
    case _ => "List does not has size 3 or doesn't have 2nd element as 2"
  }

  print(listmatch)
  /*

  1. pattern matching will intrepet the case in sequnece if any case match with input it will return that case without checking the remainging cases
  2. using default case is good practice if input does not match with any of the case it will go with default case '-'  otherwose it will throw match error

   */

}
