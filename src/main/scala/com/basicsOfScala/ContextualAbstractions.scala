package com.basicsOfScala



object ContextualAbstractions {

  val alist = List(4,2,1,3)

  val sortedList = alist.sorted

   given decendingOrder: Ordering[Int] = Ordering.fromLessThan(_ > _)
  /*

   1. sorted will take ordering as contextual parameter by default as ascending order
   2. if given instance is used in the code compiler will accept the 'decendingOrder' where the sorted method is called and sort in decensding order
   3. 'given' instance is analogous to implicit val

   contextual args will alter the behaviour of the code in the scope where the function is beign invoked
   */

  trait Combinator[A] {
    def combine(x: A, y: A): A
  }

  def combineAll[A](list: List[A])(using combinator : Combinator[A]): A =
    list.reduce((a,b) => combinator.combine(a,b))

  given intCombinator: Combinator[Int] = new Combinator[Int] {
    override def combine(x: Int, y: Int) = x + y
  }
  val theSum = combineAll(alist) // (intCombinator)

  /*

    order of where compiler looks for 'given' instances
    1. Local
    2. Imported Scope
    3. companions of all the types involved in
        list companion
        int companion

     */

  //context bounds
  def combine_v1[A](list: List[A])(using combinator: Combinator[A]): A = ???
  def combine_v2[A: Combinator](list: List[A]): A = ??? // another wayof declaring method using a contextual argument

  /*
  usage of contextual arguments
    1. type classes  -  features of functional programming
    2. dependency injection
    3. context-dependent functionality
    4. type-level programming
   */


  // Extend methods - we can define new additional methods to a type
  case class Person(name: String){
    def greet():String = s"Hi my name is $name, I love Scala"
  }

  extension (str: String){ // extension is contextual key word argument extends String Class with new function greet
    def greet(): String = new Person(str).greet()
  }

  val daniel_str = "Daniel".greet()
  println(daniel_str)

  //using extension for trait Combinator
  extension[A] (list: List[A])
    def combineAllValues(using combinator:Combinator[A]): A = list.reduce(combinator.combine)

  val extalist = alist.combineAllValues

  /*
  Other forms of contextual abstractions such as
   defining and infering type classes, implict conversions, contextual functional types in advances scala
   */
  def main(args: Array[String]) = {
    println(sortedList)
    println(theSum)
    print(extalist)
  }
}
