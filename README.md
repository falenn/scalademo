# Intro to Scala
This tutorial is based on the writeup: https://www.scala-lang.org/docu/files/ScalaTutorial.pdf.

## Objects
All things in Scala are objects!  This keeps the language from dealing with primitives. Main methods
are wrapped in objects and function as singleton objects.  Because of this, there are NO METHODS.  
Everything is declared as an object - this is probably where the object nature comes from leading to 
actors and roles?

### Infix Notation
In FrenchDate, we format a new Date object with France TimeZone:  
`df format now`
This is the equivalent syntax to writing:
`df.format(now)`
Single argument methods can be written in this way.  This is because everything is an object.

`1 + 2 * 3 / x`
This equation demonstrates this fact.  Numbers are objects!  Mathematical symbols are objects!  This 
equation can turn into the same type of method invocation if math symbols are method names:
`(1).+(((2).*(3))./(x))`
This is why * is a reserved character and not used to wildcard imcludes on imports.  We see infix 
notation used in the FrenchDate example.

### Functions are Objects!
Scala enables functional programming - functions that can be assigned to variables, passed as 
variables etc. - See this in the Timer example.

#### Anonymous Functions
These are functions without names, defined inline for expediency.  This is demonstrated also in the Timer 
example.  The symbols `=>` separate the anonymous function's arguments from its body.

## Classes
Scala does have classes - and these classes can have arguments - such that the declaration of the 
class also includes its constructor of sorts.  This is seen in the example "Complex".  The example
is driven by the main in ComplexObjects.

### Inheritance 
The generic super-class for classes without declaration is `scala.anyRef`. A class can override superclass 
methods, but must use the `override` keyword prefix to do so.  For example: `override def toString() = ...`
 
### Case Classes
This is a special form of Class / subclass inheritance that optimizes tree expressions / pattern matching. The
example for this is the Calculator program.  When using case classes `case class ...` the `new` keyword is
not required.

