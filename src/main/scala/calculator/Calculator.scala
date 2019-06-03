package calculator

object Calculator {
  type Environment = String => Int

  def main(vars: Array[String]): Unit = {

    /**
      * Let's evaluate the following equation: (x + x) + (7 + y) where x = 5 and y = 7.
      */
    var exp: Tree = Sum(Sum(Var("x"),Var("x")),Sum(Const(7),Var("y")))
    var env: Environment = { case "x" => 5 case "y" => 7 }

    println("Expression: " + exp)
    println("eval " + eval(exp,env))
    println("derivative with respect to x: " + derive(exp,"x"))
    println("derivative with respect to y: " + derive(exp,"y"))
  }

  /**
    * Almost like a case statement, we recurse down the tree given the various types that are handled
    * in the environment - a.k.a. strings and int.
    *
    * This calculator should work on expressions like 1 + 1 and x + x or x + 5 because of the Sum case.
    *
    * Adding new cases is easy!  Just create a new case Class and implement it below.
    */
  def eval(t: Tree, env: Environment): Int = t match {
    case Sum(l,r) => eval(l, env) + eval(r, env)  // This matches a a string to a sum pattern
    case Var(n)   => env(n) // this extracts the variable part of the pattern
    case Const(v) => v      // this extracts the const part of the pattern
  }

  /**
    * we could go farther and add a new operation - derivatives!
    *
    * The derivative tells us the slope of a function at any point.  Example functions are:
    * Y=3 => 0
    * y=x => 1
    * y=2x => 2
    * y=x^2 => 2x
    *
    */

  def derive(t: Tree, v: String): Tree = t match {
    //The derivative of a sum is the sum of the derivatives
    case Sum(l,r) => Sum(derive(l,v), derive(r,v))
    //the derivative of some variable v is one if v is the variable relative to which the derivation takes place,
    //and zero otherwise
    case Var(n) if (v == n) => Const(1)
    //the derivative of a constant is zero - this case also uses the wildcard matching feature "_" being something like
    //a base case.
    case _ => Const(0)
  }

}
