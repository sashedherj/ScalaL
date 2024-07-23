package udemy_scala_for_beginers.lectures.part3fp

import java.util.Random

object Options extends App {

  // options- possible absence of a value, used to avoid nullPointerExceptions
  val myFirstOption: Option[Int] = Some(4)
  val noOption: Option[Int] = None

  println(myFirstOption)

  // WORK with unsafe APIs
  def unsafeMethod(): String = null
  //  val result = Some(null) // WRONG- i.e, will always expects some value
  val result = Option(unsafeMethod()) // Some or None, based on the return value from unsafeMethod(), Option will assign some or none to result
  println(result)

  // chained methods
  def backupMethod(): String = "A valid result"
  val chainedResult = Option(unsafeMethod()).orElse(Option(backupMethod())) // if unsafeMethod return None then backup method will return gaurented result

  // DESIGN unsafe APIs
  def betterUnsafeMethod(): Option[String] = None
  def betterBackupMethod(): Option[String] = Some("A valid result")
  val betterChainedResult = betterUnsafeMethod() orElse betterBackupMethod() // if api returns options then we don't need to handle this results

  // functions on Options
  println(myFirstOption.isEmpty) // returns true of false based on some and none for the given option
  println(myFirstOption.get)  // USAFE - DO NOT USE THIS, if myFirstOption is NULL we'll get null pointer exception

  // map, flatMap, filter
  println(myFirstOption.map(_ * 2))
  println(myFirstOption.filter(x => x > 10))  // if true returns same SOME(value) else return NONE
  println(myFirstOption.flatMap(x => Option(x * 10)))

  // for-comprehensions

  /*
    Exercise.
   */
  val config: Map[String, String] = Map(
    // fetched from elsewhere
    "host" -> "176.45.36.1",
    "port" -> "80"
  )

  class Connection {
    def connect = "Connected" // connect to some server
  }
  object Connection {
    val random = new Random(System.nanoTime())

    def apply(host: String, port: String): Option[Connection] =
      if (random.nextBoolean()) Some(new Connection)
      else None
  }

  // try to establish a connection, if so - print the connect method
  val host = config.get("host")
  val port = config.get("port")
  /*
    if (h != null)
      if (p != null)
        return Connection.apply(h, p)

    return null
   */
  val connection = host.flatMap(h => port.flatMap(p => Connection.apply(h, p)))
  /*
    if (c != null)
      return c.connect
    return null
   */
  val connectionStatus = connection.map(c => c.connect) // returns an Option[String]
  // if (connectionStatus == null) println(None) else print (Some(connectionstatus.get))
  println(connectionStatus)  // o/p is undetermined depends in random.nextBoolean()
  /*
    if (status != null)
      println(status)
   */
  connectionStatus.foreach(println)

  // chained calls
  config.get("host")
    .flatMap(host => config.get("port")
      .flatMap(port => Connection(host, port))
      .map(connection => connection.connect))
    .foreach(println)

  // for-comprehensions
  val forConnectionStatus = for {
    host <- config.get("host")
    port <- config.get("port")
    connection <- Connection(host, port)
  } yield connection.connect
  
  forConnectionStatus.foreach(println)
}
