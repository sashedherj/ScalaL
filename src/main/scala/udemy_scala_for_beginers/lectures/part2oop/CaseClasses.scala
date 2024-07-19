package udemy_scala_for_beginers.lectures.part2oop

object CaseClasses extends App {

  /*
    equals, hashCode, toString
   */

  case class Person(name: String, age: Int)

  /*  Below lines of code works differntly of Person is not case class
        1. class parameters are fields
   */

  val jim = new Person("Jim", 34)
  println(jim.name)

  // 2. sensible toString
  // println(instance) = println(instance.toString) // syntactic sugar
  println(jim)

  // 3. equals and hashCode implemented out of the box implementation
  val jim2 = new Person("Jim", 34)
  println(jim == jim2)

  // 4. Case Classes - CCs have handy copy method
  val jim3 = jim.copy(age = 45)   // returns the different instance of jim with same feilds except age = 45
  println(jim3)

  // 5. CCs have companion objects
  val thePerson = Person    // automatically creates companion objects and will have factory methods
  val mary = Person("Mary", 23)

  // 6. CCs are serializable - we can send instances of case classes in Distributed Systems over the network 
  // Akka

  // 7. CCs have extractor patterns = CCs can be used in PATTERN MATCHING

  case object UnitedKingdom {   // case objects are same cc's excepts they have companion objects because they're companion objects to itself
    def name: String = "The UK of GB and NI"
  }

  /*
    Expand MyList - use case classes and case objects
   */
}
