/**
  * Example shows import of java libs into example.  The static method getDateInstance on DateFormat is distinctly
  * accessible - no preceding DateFormat reference!  Same with the field LONG
  */

import java.util.{Date, Locale}
import java.text.DateFormat._

object FrenchDate {
  def main(args: Array[String]): Unit = {
    val now = new Date
    val df = getDateInstance(LONG, Locale.FRANCE)

    /**
      * Demonstration of infix notation - the method: df format now  - this is the same as writing
      * df.format(now)
      */
    println(df format now)
  }
}
