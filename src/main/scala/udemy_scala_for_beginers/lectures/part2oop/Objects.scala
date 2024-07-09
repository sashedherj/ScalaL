package udemy_scala_for_beginers.lectures.part2oop

object Objects extends App {

  // SCALA DOES NOT HAVE CLASS-LEVEL FUNCTIONALITY ("static")   refer to playground.JavaPlayground.java for class-lvl-functionality
  /*
  to implement class level functionality in scala use object similar to class can have val/var/methods
   */
  object Person { // Person is  type + its only instance called as singleton instance
    // "static"/"class" - level functionality using objects
    val N_EYES = 2
    def canFly: Boolean = false

    // factory method
    def apply(mother: Person, father: Person): Person = new Person("Bobbie")
    def from(mother: Person, father: Person): Person = new Person("Bobbie")

  }
  class Person(val name: String) {
    // instance-level functionality
  }
  // COMPANIONS - class Person and object Person are companions i,e. Person is declared as both object and class

    println(Person.N_EYES)
    println(Person.canFly)

    // Scala object = SINGLETON INSTANCE
    val mary = new Person("Mary")
    val john = new Person("John")
    println(mary == john)   // evaluates to false because both are different instances of class Person

    val person1 = Person
    val person2 = Person
    println(person1 == person2)  // evaluates to true because both are same instances of object Person

    val bobbie = Person(mary, john)  // called as factory mthod that takes its companion class objects  and return same class type object
  //  val bobbie = Person.from(mary, john)  // replace from with apply, same as apply factory method


  // Scala Applications = Scala object with
  // def main(args: Array[String]): Unit
}
