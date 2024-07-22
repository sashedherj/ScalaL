package udemy_scala_for_beginers.lectures.part2oop

object Enums {

  enum Permissions {   // Permissions is data type which is already sealed, and cannot be extended and we can use it as constants
    case READ, WRITE, EXECUTE, NONE

    // as it is a data type we can add some fields/methods
    def openDocument(): Unit =
      if (this == READ) println("opening document...")
      else println("reading not allowed.")
  }

  val somePermissions: Permissions = Permissions.READ

  // new enum with constructor args
  enum PermissionsWithBits(bits: Int) {
    case READ extends PermissionsWithBits(4) // 100
    case WRITE extends PermissionsWithBits(2) // 010
    case EXECUTE extends PermissionsWithBits(1) // 001
    case NONE extends PermissionsWithBits(0) // 000
  }

  // enums can also have companion objects, can be used as source for factory methods
  object PermissionsWithBits {
    def fromBits(bits: Int): PermissionsWithBits = // whatever
      PermissionsWithBits.NONE
  }

  // standard API that available with every enum we defined
  val somePermissionsOrdinal = somePermissions.ordinal  // returns zero i,e. read is defined at index 0 
  val allPermissions = PermissionsWithBits.values // returns array of all possible values of the enum
  val readPermission: Permissions = Permissions.valueOf("READ") // Permissions.READ

  def main(args: Array[String]): Unit = {
    somePermissions.openDocument()
    println(somePermissionsOrdinal)
    println(Permissions.WRITE.toString)
    
    println(readPermission)   // returns read constant  defined in enum type
    println(allPermissions.toString)
  }
}
