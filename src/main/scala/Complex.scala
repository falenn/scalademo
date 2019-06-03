/**
  * Example of a class definition.  Notice defining the class also includes its constructor
  * @param real
  * @param imaginary
  */
class Complex(real: Double, imaginary: Double) {

  //Define functions to access the arguments passed in when creating an instance of Complex
  //Notice, no return type was specified - it was deduced by the compiler as Double.
  def re() = real

  //This function is explicitly defined with no arguments and thus does not require parenthesis
  def im = imaginary

  //This overrides the toString method on the super-class `scala.anyRef`
  override def toString: String =
    "" + re + (if(im < 0) "" else "+") + im + "i"
}
