
---
## 1. SCALA BASICS & LANGUAGE FEATURES


### 1. What are the key differences between `var`, `val`, and `lazy val`?
**Explanation:**  
`val` is immutable and initialized immediately. `var` is mutable and should be avoided in FP-heavy code. `lazy val` is immutable but evaluated only once on first access, useful for expensive initialization. Lazy vals are thread-safe after initialization.

**Example:**
```scala
val a = 10
var b = 20
lazy val expensive = { println("run"); 42 }
println(expensive) // prints "run" once
```

---

### 2. What is the difference between `def`, `val`, and `lazy val` in method definitions?
**Explanation:**  
`def` is evaluated every time it's called.  
`val` is evaluated once and stored.  
`lazy val` is evaluated once only when accessed.  
Useful for controlling evaluation strategy.

**Example:**
```scala
def f = { println("run f"); 1 }
val g = { println("run g"); 2 }
lazy val h = { println("run h"); 3 }
```

---

### 3. What is the difference between `object` and `class`?
**Explanation:**  
A `class` defines a blueprint.  
An `object` is a singleton instance.  
`object` can be used for utilities, factories, and companion objects that access private class members.

**Example:**
```scala
class User(val name: String)
object User {
  def apply(n: String) = new User(n)
}
```

---

### 4. What is a companion object?
**Explanation:**  
A companion object has the same name as a class and resides in the same file. It can access the class’ private members. Often used for factory methods, constants, or typeclass instances.

**Example:**
```scala
class A private (x: Int)
object A {
  def apply(x: Int) = new A(x) // factory
}
```

---

### 5. What is the difference between `apply` and `unapply`?
**Explanation:**  
`apply` builds objects (constructor-like).  
`unapply` deconstructs objects (used in pattern matching).  
Together they support custom creation and extraction patterns.

**Example:**
```scala
object Email {
  def apply(u: String, d: String) = s"$u@$d"
  def unapply(s: String) = s.split("@") match {
    case Array(u,d) => Some((u,d))
    case _ => None
  }
}
```

---

### 6. Explain pass-by-name vs pass-by-value.
**Explanation:**  
Pass-by-value evaluates the argument before the call.  
Pass-by-name evaluates the argument each time it is used in the function.  
Great for controlling evaluation, implementing loops, or lazy behavior.

**Example:**
```scala
def byValue(x: Int) = x + x
def byName(x: => Int) = x + x
```

---

### 7. What is tail recursion?
**Explanation:**  
A tail-recursive function’s final expression is the recursive call. Scala can optimize it to a loop, preventing stack overflow. Requires `@tailrec` annotation to enforce optimization.

**Example:**
```scala
@tailrec
def sum(n: Int, acc: Int = 0): Int =
  if (n == 0) acc else sum(n - 1, acc + n)
```

---

### 8. What is call-by-need?
**Explanation:**  
Scala’s lazy evaluation strategy: compute once, then reuse. Equivalent to memoized call-by-name. Implemented via `lazy val` or `=>` with caching.

**Example:**
```scala
lazy val x = { println("once"); 99 }
```

---

### 9. Difference between `==` and `eq`?
**Explanation:**  
`==` checks structural equality (delegates to `equals`).  
`eq` checks reference equality, only for JVM reference types.

**Example:**
```scala
val a = "hi"; val b = "hi"
a == b   // true
a eq b   // false (usually)
```

---

### 10. What are case classes used for?
**Explanation:**  
Immutable data structures with auto-generated `equals`, `hashCode`, `copy`, and extractor `unapply`. Ideal for ADTs, pattern matching, DTOs.

**Example:**
```scala
case class User(name: String, age: Int)
val u = User("Amol", 30)
```

---

## ===========================================
## 2. COLLECTIONS
## ===========================================

### 11. Mutable vs immutable collections?
**Explanation:**  
Immutable collections return new versions on modification; thread-safe and functional. Mutable collections allow in-place updates; faster but harder to reason about. Scala defaults to immutable.

**Example:**
```scala
val imm = List(1,2,3)
var mut = scala.collection.mutable.ListBuffer(1,2,3)
```

---

### 12. Difference between `map`, `flatMap`, `filter`?
**Explanation:**  
`map` transforms elements.  
`flatMap` transforms + flattens one level.  
`filter` keeps elements satisfying predicate.  
Common in FP, monads, collections.

**Example:**
```scala
List(1,2).flatMap(x => List(x, x*10))
```

---

### 13. What is `foldLeft` vs `foldRight`?
**Explanation:**  
`foldLeft` is tail-recursive, processes left-to-right, efficient for large lists.  
`foldRight` is not tail-recursive (unless using lazy structures), processes right-to-left.  
Different associativity.

**Example:**
```scala
List(1,2,3).foldLeft(0)(_+_)
```

---

### 14. What is `reduce` vs `fold`?
**Explanation:**  
`fold` takes an initial accumulator.  
`reduce` uses the first element as accumulator, so the collection must be non-empty.  
`reduce` is more restrictive.

**Example:**
```scala
List(1,2,3).reduce(_+_)
```

---

### 15. Explain `collect`.
**Explanation:**  
Combines filtering + mapping using partial functions. Only inputs matching a `case` clause are processed. Very handy for pattern-based extraction.

**Example:**
```scala
List(1, "a", 2).collect { case i: Int => i * 10 }
```

---

### 16. What is `groupBy`?
**Explanation:**  
Partitions a collection into a map where keys come from a function. Useful for classification, aggregation, bucketing.

**Example:**
```scala
List("a","aa","bb").groupBy(_.length)
```

---

### 17. Difference between `Seq`, `List`, `Vector`?
**Explanation:**  
`List` = linked list (fast head, slow indexing).  
`Vector` = tree-based, fast random access (default).  
`Seq` = trait; could be either.  
Vector is preferred for most use cases.

**Example:**
```scala
val v = Vector(1,2,3)
```

---

### 18. Explain `view`.
**Explanation:**  
Creates a non-strict (lazy) collection transformation pipeline. Evaluates only when needed. Useful for performance on large collections.

**Example:**
```scala
val v = (1 to 100000).view.map(_+1)
```

---

### 19. What is `iterator`?
**Explanation:**  
Provides lazy, one-pass traversal over a collection. Does not build intermediate collections. Good for streaming data.

**Example:**
```scala
List(1,2,3).iterator.foreach(println)
```

---

### 20. Explain `zip`, `sliding`, `scan`.
**Explanation:**  
`zip` pairs elements.  
`sliding` creates overlapping windows.  
`scan` generates intermediate fold results.

**Example:**
```scala
List(1,2,3).scan(0)(_+_)   // List(0,1,3,6)
```

---

## ===========================================
## 3. FUNCTIONAL PROGRAMMING (FP)
## ===========================================

### 21. What are higher-order functions?
**Explanation:**  
Functions taking other functions as arguments or returning functions. Enable FP patterns like map/filter/fold, currying, composition.

**Example:**
```scala
def twice(f: Int => Int) = f(f(10))
```

---

### 22. What is a pure function?
**Explanation:**  
No side effects and deterministic output for same input. Makes reasoning, testing, and concurrency easier.

**Example:**
```scala
def add(a:Int,b:Int) = a+b
```

---

### 23. Explain closures.
**Explanation:**  
A closure captures variables from its defining scope. The captured variables remain accessible even outside their home scope.

**Example:**
```scala
var x = 10
val f = () => x + 1
```

---

### 24. Currying vs partial application?
**Explanation:**  
Currying transforms a multi-arg function into nested functions.  
Partial application fixes some arguments to create a new function.

**Example:**
```scala
def add(a:Int)(b:Int)=a+b
val add2 = add(2) _
```

---

### 25. Referential transparency?
**Explanation:**  
An expression is referentially transparent if replacing it with its value does not change program behavior. Foundation of FP/immutability.

**Example:**
```scala
val x = 1 + 1
```

---

### 26. What is immutability?
**Explanation:**  
Values cannot be modified after creation. Improves thread safety and reasoning. Core principle of FP.

**Example:**
```scala
val a = List(1,2,3)
val b = a :+ 4
```

---

### 27. Explain function composition.
**Explanation:**  
Combining two functions to form a new function. Scala uses `andThen` and `compose`.

**Example:**
```scala
val f = (x:Int)=>x+1
val g = (y:Int)=>y*2
val h = f andThen g
```

---

### 28. Explain PartialFunctions.
**Explanation:**  
A function defined only for some inputs. Supports `isDefinedAt`. Used in `collect`, actors, pattern-based APIs.

**Example:**
```scala
val pf: PartialFunction[Int,String] = { case x if x > 0 => "pos" }
```

---

### 29. What are monoids, functors, monads?
**Explanation:**  
Functor = map.  
Monoid = associative binary op + identity.  
Monad = flatMap + map with specific laws.  
Used for composition, effects, abstractions.

**Example:**
```scala
Option(2).map(_+2).flatMap(x => Some(x*10))
```

---

### 30. Explain `Option`, `Either`, `Try`.
**Explanation:**  
`Option` = missing values.  
`Either` = two-branch error handling.  
`Try` = exception capturing.  
Improves safety over nulls/exceptions.

**Example:**
```scala
Try(10/0).recover{case _ => 0}
```

---

## ===========================================
## 4. OOP + TYPE SYSTEM
## ===========================================

### 31. What are traits?
**Explanation:**  
Reusable behavior that can be mixed into classes. Support multiple inheritance. Traits can have concrete and abstract members.

**Example:**
```scala
trait Log { def info(msg:String): Unit = println(msg) }
```

---

### 32. Abstract class vs trait?
**Explanation:**  
Traits: multiple inheritance, no constructor params.  
Abstract classes: cannot mix into objects, can have constructor params.  
Prefer traits unless needing constructor arguments.

**Example:**
```scala
abstract class A(x:Int)
trait T
```

---

### 33. What is a self-type?
**Explanation:**  
A declaration in traits indicating required mixing type. Used in dependency injection and enforcing constraints.

**Example:**
```scala
trait Auth { self: UserRepo => }
```

---

### 34. Method overloading vs overriding?
**Explanation:**  
Overloading = same name, different parameters.  
Overriding = redefining inherited method.  
Requires `override` keyword.

**Example:**
```scala
override def toString = "Hi"
```

---

### 35. What are implicit classes?
**Explanation:**  
Add extension methods to existing types without modifying them. Must be inside an object and take exactly one param.

**Example:**
```scala
implicit class RichInt(i:Int){ def sq = i*i }
```

---

### 36. What is covariance/contravariance?
**Explanation:**  
`+A` allows substituting subtype.  
`-A` allows substituting supertype.  
Important in generics and function arguments.

**Example:**
```scala
class Box[+A]
```

---

### 37. What is a type alias?
**Explanation:**  
Gives a shorter or more semantic name to a type. Helps readability and abstraction.

**Example:**
```scala
type UserId = String
```

---

### 38. What are structural types?
**Explanation:**  
Types defined by structure instead of inheritance. Useful but slow (reflection). Avoid in performance-critical code.

**Example:**
```scala
def closeable(x: { def close(): Unit }) = x.close()
```

---

### 39. Path-dependent types?
**Explanation:**  
A type that depends on an instance value. Useful for DSLs, scoped resources.

**Example:**
```scala
class Outer { class Inner }
val o = new Outer
val i: o.Inner = new o.Inner
```

---

### 40. What are type bounds?
**Explanation:**  
Restrict type parameters: upper bounds `<:`, lower bounds `>:`, or both. Increase type safety.

**Example:**
```scala
def max[A <: Ordered[A]](a:A,b:A) = if(a>b) a else b
```

---

## ===========================================
## 5. PATTERN MATCHING & ADTs
## ===========================================

### 41. What are sealed traits?
**Explanation:**  
All implementations must be in the same file. Helps exhaustiveness checking in pattern matching.

**Example:**
```scala
sealed trait Shape
case class Circle(r:Int) extends Shape
```

---

### 42. Difference between pattern guards and cases?
**Explanation:**  
Guards add boolean conditions to patterns. Useful for filtering.

**Example:**
```scala
x match { case n if n > 10 => "big" }
```

---

### 43. What is extractor pattern?
**Explanation:**  
Defines custom `unapply` for pattern matching. Enables matching on arbitrary types.

**Example:**
```scala
object Twice { def unapply(i:Int)=Some(i*2) }
```

---

### 44. What is wildcard pattern `_`?
**Explanation:**  
Matches anything without binding. Used for ignoring or default cases.

**Example:**
```scala
list match { case _ => "anything" }
```

---

### 45. Matching on type?
**Explanation:**  
Type-based pattern matching uses runtime checks. Not perfect due to erasure.

**Example:**
```scala
x match { case s: String => ... }
```

---

### 46. Deep pattern matching?
**Explanation:**  
Match nested structures directly. Great for ADTs and complex DSLs.

**Example:**
```scala
case List(a,b,c) => ...
```

---

## ===========================================
## 6. IMPLICITS & TYPECLASSES
## ===========================================

### 47. Implicit parameters?
**Explanation:**  
Scala automatically supplies values from scope. Powerful for typeclasses, context passing, dependency injection.

**Example:**
```scala
def greet(name:String)(implicit prefix:String)= prefix+name
implicit val p="Hi "
```

---

### 48. Implicit conversions?
**Explanation:**  
Automatic type conversion when types mismatch. Must be used sparingly. Can lead to hidden bugs; avoid unless necessary.

**Example:**
```scala
implicit def intToStr(i:Int)=i.toString
```

---

### 49. What are typeclasses?
**Explanation:**  
A pattern using implicits: define behavior by type, not inheritance. Allows ad-hoc polymorphism.

**Example:**
```scala
trait Show[A]{ def show(a:A):String }
implicit val showInt = new Show[Int]{def show(a:Int)=a.toString}
```

---

### 50. Context bounds?
**Explanation:**  
Syntactic sugar for implicit typeclass parameters. Cleaner syntax.

**Example:**
```scala
def print[A:Show](a:A)(implicit s:Show[A])=s.show(a)
```

---

### 51. Evidence parameters?
**Explanation:**  
Implicit proofs that certain types satisfy constraints (`=:=`, `<:<`). Used for type-level programming.

**Example:**
```scala
def onlyInt[A](a:A)(implicit ev: A =:= Int) = a + 1
```

---

### 52. Implicit resolution priority?
**Explanation:**  
Compiler chooses the most specific implicit. Local > companion > imported. Ambiguity causes compiler errors.

**Example:**
```scala
implicit val a = 10
implicit val b = 20 // error if both apply
```

---

## ===========================================
## 7. CONCURRENCY (FUTURES, PROMISES, AKKA)
## ===========================================

### 53. What is a Future?
**Explanation:**  
Represents asynchronous computation. Executes on an ExecutionContext. Non-blocking, callback-based.

**Example:**
```scala
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

Future(println("async"))
```

---

### 54. What is ExecutionContext?
**Explanation:**  
Thread pool used to run Futures. Default uses ForkJoin pool. Required for async operations.

**Example:**
```scala
implicit val ec = ExecutionContext.global
```

---

### 55. Future vs Promise?
**Explanation:**  
Future = read-only handle.  
Promise = writable side that completes the future.  
Useful for manually completing async computations.

**Example:**
```scala
val p = Promise[Int]()
p.success(42)
```

---

### 56. What is blocking vs non-blocking?
**Explanation:**  
Blocking waits for results (`Await.result`). Non-blocking uses callbacks (`onComplete`). Blocking is discouraged in production.

**Example:**
```scala
Await.result(Future(10), 1.second)
```

---

### 57. What is Akka Actor?
**Explanation:**  
Lightweight entity communicating via async messages. Eliminates shared mutable state. Based on Actor model.

**Example:**
```scala
class MyActor extends Actor { def receive = { case x => println(x) } }
```

---

### 58. Actor supervision?
**Explanation:**  
Parent actors monitor and restart child actors on failure. Implements resilient systems.
“Supervision Strategy is Akka’s built-in fault-tolerance mechanism.
Whenever a child throws an exception, the parent decides whether to restart, resume, stop or escalate the child.
This gives the system self-healing capabilities.
Instead of spreading try/catch everywhere, we centralize failure handling at the parent actor, making the entire system resilient and predictable.”

**Example:**
```scala
override val supervisorStrategy = OneForOneStrategy(){ case _ => Restart }
```

---

### 59. Akka message immutability?
**Explanation:**  
Messages must be immutable to ensure safe concurrency. Prevents race conditions and shared mutations.

**Example:**
```scala
case class Msg(x:Int)
```

---

### 60. What is Akka routing?
**Explanation:**  
Distributes messages across actors. Useful for parallelism and load-balancing.

**Example:**
```scala
val router = system.actorOf(RoundRobinPool(5).props(Props[Worker]))
```

---

## ===========================================
## 8. JVM, PERFORMANCE & MEMORY
## ===========================================

### 61. What is JVM heap vs stack?
**Explanation:**  
Stack = holds frames, local variables.  
Heap = allocated objects, GC-managed.  
Scala runs on JVM so same runtime behavior applies.

**Example:** _N/A conceptual_

---

### 62. What is garbage collection?
**Explanation:**  
Automatically frees unreachable objects. JVM runs GC algorithms like G1, Parallel. Helps memory safety.

---

### 63. Value class?
**Explanation:**  
Optimized by erasure; wraps a value without allocating objects. Useful for performance but restricted.

**Example:**
```scala
class Meter(val value:Int) extends AnyVal
```

---

### 64. Boxing/unboxing?
**Explanation:**  
Scala converts primitive types to reference types (boxing) and back (unboxing). Occurs with generics and collections.

**Example:**
```scala
val x: Any = 10 // boxed
```

---

### 65. Tail-call optimization?
**Explanation:**  
Scala performs TCO only for final tail calls. Otherwise, stack grows. Helps avoid recursion overflow.

---

### 66. Benchmarking in Scala?
**Explanation:**  
Use JMH (Java Microbenchmark Harness). Avoid naive System.nanoTime tests due to JVM optimizations.

**Example:** _benchmark only_

---

### 67. What is escape analysis?
**Explanation:**  
JVM optimization that allocates objects on stack or eliminates allocation if object doesn't escape method.

---

### 68. HotSpot JIT?
**Explanation:**  
JVM compiles bytecode to native code at runtime for performance. Optimizes frequently used paths.

---

## ===========================================
## 9. BEST PRACTICES & ADVANCED CONCEPTS
## ===========================================

### 69. Idiomatic Scala coding practices?
**Explanation:**  
Prefer immutability, use expressions over statements, avoid null, use pattern matching, prefer pure functions, use Option/Either instead of exceptions.

---

### 70. What is a DSL in Scala?
**Explanation:**  
Domain-specific languages using operator overloading, implicit conversions, and type system. Scala’s flexible syntax helps DSL creation.

**Example:**
```scala
1 to 10
```

---

### 71. What is the Cake Pattern?
**Explanation:**  
A complex dependency injection technique using self-types and traits. Avoid if possible; modern DI uses ZIO / MacWire / Guice.

---

### 72. What is Tagless Final?
**Explanation:**  
Functional pattern for effect abstraction using typeclasses instead of monad transformers. Popular in FP ecosystems.

---

### 73. What is TypeTag / ClassTag?
**Explanation:**  
Runtime type information retained for generic types (needed due to type erasure). Useful for reflection and pattern matching.

**Example:**
```scala
def mkArr[T: ClassTag](xs:T*) = Array(xs:_*)
```

---

### 74. What is shapeless?
**Explanation:**  
Generic programming library. Supports type-level programming, HList, automatic derivation. Heavy but very powerful.

---

### 75. Macros in Scala?
**Explanation:**  
Compile-time metaprogramming. Generate code, validate types, remove boilerplate. Powerful but complex.

---

