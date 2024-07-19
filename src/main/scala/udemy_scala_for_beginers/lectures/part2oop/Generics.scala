package udemy_scala_for_beginers.lectures.part2oop

object Generics extends App {

  class MyList[+A] {
    // use the type A
    def add[B >: A](element: B): MyList[B] = ???
    /*
      A = Cat
      B = Dog => Animal
     */
  }

  class MyMap[Key, Value]

  val listOfIntegers = new MyList[Int]
  val listOfStrings = new MyList[String]

  // generic methods
  /*
    1. traits can also be defined using type parameters - []
    2. Objects cannot be type parameterised
  */
  object MyList {
    def empty[A]: MyList[A] = ???
  }
  val emptyListOfIntegers = MyList.empty[Int]

  // variance problem
  // (don't stress about it)
  class Animal
  class Cat extends Animal
  class Dog extends Animal

  // Q. can list of cat extends list of animal- 2 possible answers
  // 1. yes, List[Cat] extends List[Animal] = COVARIANCE
  class CovariantList[+A]     // +A specifies this class is covariant type
  val animal: Animal = new Cat
  val animalList: CovariantList[Animal] = new CovariantList[Cat]   // similar to polymorphic substitution - dynamic polymorphism
  // animalList.add(new Dog) ??? HARD QUESTION => we return a list of Animals because both cats and dogs are animals  will define add function as  def add[B >: A](element: B): MyList[B] = ???

  // 2. NO = INVARIANCE
  class InvariantList[A]
  val invariantAnimalList: InvariantList[Animal] = new InvariantList[Animal]   // only Animal needs to be specified

  // 3. Hell, no! CONTRAVARIANCE   - reverse of CovariantList
  class Trainer[-A]
  val trainer: Trainer[Cat] = new Trainer[Animal]

  // bounded types
  class Cage[A <: Animal](animal: A)    // class cage only allows generics which are subclass of animals
                                        // if: Cage[A >: Animal] then cage class allows only super class of animals
  val cage = new Cage(new Dog)

  class Car
  // generic type needs proper bounded type
  //  val newCage = new Cage(new Car)


  // expand MyList to be generic

}
