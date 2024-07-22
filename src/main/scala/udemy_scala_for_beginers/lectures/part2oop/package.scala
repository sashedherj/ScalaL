package udemy_scala_for_beginers.lectures

// when we want define methods or constants outside class/ object we can define then in package objects
// package object can only be one per package name of object can be name of folder 
// the methods/ feilds are universal for entire package

package object part2oop {
  def sayHello: Unit = println("Hello, Scala")
  val SPEED_OF_LIGHT = 299792458
}
