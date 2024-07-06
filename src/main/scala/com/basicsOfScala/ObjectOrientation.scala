package com.basicsOfScala

object ObjectOrientation extends App {

  /*
   methods on object blocks are similar to static methods in java - can directly instantiated without classed
   'ObjectOrientation' - object is runnable because it extends from App which has static  main method init

   extends App -> public static void main(String[] args) in java
  */
  class Animal {
    var age: Int = 10

    def eat(): Unit = print("I Eat anything")
  }

  var dg = new Animal
  print("1", dg.age)
  print("2", dg.eat())

  // simple inheritance
  class Dog(name: String) extends Animal { //constructor variable :name can not be accessed by object because it not a field to promote to filed use val/var
    //constructor variables(without var/val) are ephemeral which are not able to access outside the definition of class
    def nameOfDog(): Unit = print(s"name of the dog is $name")
  }

  var aDog = new Dog("lucy")
  aDog.nameOfDog()
  print("3", aDog.age)
  // print(aDog.name) // to access constructor variable  declare  name as var -> class Dog(var name: String) extends Animal
  aDog.eat()
  aDog.age = 25


  //  subtype Polymorphism
  var anAnimal: Animal = new Dog("Cauchy")
  anAnimal.eat() // at compile time anAnimal var refers to eat method in Base Class but in runtime it will refer to
  // most derived method . if eat() is defined in Dog() then it will be called in runtime


  //  abstract classes - some methods in base class left umimplemented
  abstract class WalkingAnimal {
    var hasLegs = false // by default all variables are public, for specific we declare with protected and public
    // protected - has access to same class and its decendents
    // private   - had access to its own class only

    def walking(): Unit // need to be defined in derived classes
  }

  class Mammal extends WalkingAnimal {
    override def walking() = {
      if (!hasLegs)
        print(s"I walk with legs")
      else
        print("I dont have legs")
    }
  }

  var cat = new Mammal
  cat.walking()


  //  interfaces( ultimate abstraction) -  all methods in base class are left unimplemented
  trait Carnivore {
    def eat(animal: Animal): Unit
  }

  trait Philosopher {
    def ?!(thought: String): Unit //methods names can any symbol
  }

  //  Scala offers single class inheritance and multi-trait( mixing ) inheritance. Trait == interface (ultimate abstraction)
  class Crocodile extends Animal with Carnivore with Philosopher {
    override def eat(animal: Animal) = print(s"I'm eating you ${animal.age} ")
    // override key is used override the medhod in base class
    override def eat(): Unit = super.eat() //override base class method

    override def ?!(thought: String) = print(s"I'm thinking of $thought")
  }

  var areptile = new Crocodile
  areptile.eat(anAnimal)
  areptile.eat()
  areptile.eat(aDog) // we can also pass derived class fobject
  //  infix notation - only for methods with single parameter
  areptile eat aDog // same as above code line ==  areptile.eat(aDog)
  areptile ?! "Nothing"

  //  In Scala every operator is a Method
  var temp = 10 + 20
  var temp1 = 10.+(20) // both are same + is method name 10 + 20 is infix notation, and  10.+(20) is obj.method(parameter) notation
  print(s"5. temp= $temp, temp1=$temp1")

  //  Anonymous Classes
  /* In other statically typed languages we cannot directly instantiate interface which are need to extended by a concrete class
  but in scala we define traits using anonymous class by directly override methods without a class name
  */
  var dino = new Carnivore {
    override def eat(animal: Animal) = print(s"Dinosur here ${animal.age}")
  }
  dino.eat(anAnimal)
  /*
  same as above implementation for Anonymous classes
  class Dinosour_345234 extends Carnivore{
    override def eat(animal: Animal) = print(s"Dinosur here ${animal.age}")
  }
  var dino = new Dinosour_345234;
  */

  // Single-Ton Objects
  //In scala, there is no static concept. So scala creates a singleton object to provide entry point for your program execution.
  object MySingleTon { // only instance of MysingleTon type with variables and methods
    var age: Int = 25

    def message(msg: String): Unit = print(s"Message is $msg")

    def apply(x: Int): Int = x + 1 //presence of apply method in singleton object or any classes, they can be invoked as methods directly -> refer invoking of apply() below
  }

  print(MySingleTon.age)
  MySingleTon.message("HI")
  print(MySingleTon(97), MySingleTon.apply(97)) // my default singleton object will invoke apply function

  //  companion objects
  object Animal { //class Animal and object Animal are companions
    // pros - companions can access each other private fields(variables, methods)
    //Singleton  Animal and Instances of classs Animal are 2 different things
    var canLiveIndefinately = false

  }

  var animalCanLiveIndifinatey = Animal.canLiveIndefinately // similar to accessing static feilds/methods in java/cpp
  print(animalCanLiveIndifinatey)

  /*
  case classes - Light Weight Data structures with some boiler plate
  for case classes compiler will generate sensible equals and hash code
  serializarion, companion with apply, pattern matching
   */

  case class Person(name: String,age: Int)

  var bob = new Person("Bob", 35) // person can be instansiated without new keyword also
  //  person.apply("Bob", 35) case classes will have companion objects (like apply method)
  print(bob.age, bob.name)

  def check_caseClass(cls_id : Person): Unit= {  //for case class we can access constructor variables with class object directly
    print(cls_id.name, cls_id.age)
  }

  //  exceptions
  /*
  any code written in scala will be compliled to jvm - byte code, that can run any jvm supported platforms
   */
  try {
    // code that can throw
    val x: String = null
    val y:Int  = x.length  // accessing the feild length on null object throws an exception
    print(s"length of string is $y")
  }
  catch { // in Java: catch(Exception e) {...}
    case e: Exception => s"some faulty error message $e"
  }
  finally {
    // execute some code no matter what

  }

  //using Generics - similar to templating in C++
  //generally works with abstract classes as well as traits
  abstract class MyList[X]{
    def head : X
    def Tail : MyList[X]
  }
  // use generic with concrete type
  var li:List[Int] = List(1,2,3)   // list with Int type
  print(li.head)
  print(li.tail)
  var st_li :List[String] = List("Alice","Bob","Charlie") // List with string elements
  print(st_li.length,st_li.last)
  print(st_li.head,st_li.tail)


  /*
  point #1: In Scala we normally deal with Immutable Types
  Any Modification to Immutable Types returns an another

    var reversed_list = st_li.reverse()  // retruns another list
    pro's - works miracles in multi-threaded/distibuted environment
          - makes sense of code

   point #2: Scala is closest to object oriented ideal
   i.e, every value or the method are instance of some type like object/ class/ trait or abstract class
    no values or methods outside the class/object can instanciated
   */
}