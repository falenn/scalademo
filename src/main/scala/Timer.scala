/**
  * Unit - this is equivelent to void
  * A type of function which takes no arguments and returns void
  */
object Timer {
  def oncePerSecond(count: Int, callback: () => Unit) {
    var i = 0;
    for(i <- 1 to count) {
      // The oncePerSecond function takes a function as an argument - the callback function is executed here.
      callback();
      Thread sleep 1000
    }
  }

  /**
    * This is the defined function that will be used as the callback function.  It can take no arguments and
    * must return void to be used as a Unit - a callback
    */
  def timeFlies() {
    println("time flies like an arrow...")
  }

  def havingFun() {
    println("...while writing scala!")
  }

  /**
    * The Main function
    * @param args
    */
  def main(args: Array[String]) {
    //the invocation of oncePerSecond function with a callback function
    oncePerSecond(1, timeFlies)
    oncePerSecond(1, havingFun)

    //now, use the timerFunction with an anonymous function
    oncePerSecond(1, () =>
      println("This is anonymous"))
  }
}
