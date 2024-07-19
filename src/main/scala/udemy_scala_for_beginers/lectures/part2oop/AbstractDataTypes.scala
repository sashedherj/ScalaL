package udemy_scala_for_beginers.lectures.part2oop

object AbstractDataTypes extends App {

  // abstract
  abstract class Animal {
    val creatureType: String = "wild"
    def eat: Unit
  }

  class Dog extends Animal {
    override val creatureType: String = "Canine"
    def eat: Unit = println(s"crunch crunch")        //abstract is optional for abstract members
  }

  // traits - ultimate abstract classes
  trait Carnivore {
    def eat(animal: Animal): Unit
    val preferredMeal: String = "fresh meat"
  }

  // traits can also be extended along with classes (indirectly implementing multiple inheritance )
  trait ColdBlooded
  class Crocodile extends Animal with Carnivore with ColdBlooded {    // you can add as many traits as required  like trait ClodBlooded
    override val creatureType: String = "croc"
    def eat: Unit = println("nomnomnom")
    def eat(animal: Animal): Unit = println(s"I'm a croc and I'm eating ${animal.creatureType}")
  }

  val dog = new Dog
  dog.eat
  val croc = new Crocodile
  croc.eat(dog)

  /*
       traits vs abstract classes
      1 - traits do not have constructor parameters
      2 - multiple traits may be inherited by the same class
      3 - traits = behavior, abstract class = "thing"
   */

}
