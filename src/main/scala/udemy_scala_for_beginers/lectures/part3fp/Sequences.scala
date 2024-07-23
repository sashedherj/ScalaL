package udemy_scala_for_beginers.lectures.part3fp

import scala.util.Random

object Sequences extends App {

  // Seq
  val aSequence = Seq(1,3,2,4)  // so compananion object has apply factory method  that can build subclasses
  println(aSequence)
  println(aSequence.reverse)
  println(aSequence(2))
  println(aSequence ++ Seq(7,5,6))
  println(aSequence.sorted)

  // Ranges
  val aRange: Seq[Int] = 1 until 10
  aRange.foreach(println)

  (1 to 10).foreach(x => println("Hello"))

  // lists
  val aList = List(1,2,3)
  val prepended = 42 +: aList :+ 89    // 42 :: alist  syntactic sugar for apply method in aList
  println(prepended)

  val apples5 = List.fill(5)("apple")  // fill is a curried function construct a list with string- apple 5x
  println(apples5)
  println(aList.mkString("-|-"))

  // arrays
  val numbers = Array(1,2,3,4)
  val threeElements = Array.ofDim[String](3)
  threeElements.foreach(println)

  // mutation
  numbers(2) = 0  // syntax sugar for numbers.update(2, 0), update is also a special method like apply and available in mutable collections
  println(numbers.mkString(" "))

  // arrays and seq
  val numbersSeq: Seq[Int] = numbers  // implicit conversion - numbers array is WrappedArray in sequence
  println(numbersSeq)

  // vectors
  val vector: Vector[Int] = Vector(1,2,3)
  println(vector)

  // vectors vs lists

  val maxRuns = 1000
  val maxCapacity = 1000000

  def getWriteTime(collection: Seq[Int]): Double = {
    val r = new Random
    val times = for {
      it <- 1 to maxRuns
    } yield {
      val currentTime = System.nanoTime()
      collection.updated(r.nextInt(maxCapacity), r.nextInt())
      System.nanoTime() - currentTime
    }

    times.sum * 1.0 / maxRuns
  }

  val numbersList = (1 to maxCapacity).toList
  val numbersVector = (1 to maxCapacity).toVector

  /*  -> List
      pro - keeps reference to tail
      con - updating an element in the middle takes long as entire reference to the tail need to modified
   */
  println(getWriteTime(numbersList))
  
  /*  -> Vector
      pro -  depth of the tree is small
      con -  needs to replace an entire 32-element chunk - takes less time compared to List as it is effective constant indexed trie O(log32(n))
   */
  println(getWriteTime(numbersVector))

}
