import HelloWorld.findFirst
import List.sum

import scala.annotation.tailrec

object HelloWorld extends App {

  // println("Hello World!")
  // println("factorial for 5: ", factorial(5))
  // println("fibonacci position at 5: ", fibonacci(5))

  /* Polymorphic functions:
   * next statement is for monomorphic (typed) function, just works with String type
   *    var position = findFirst(Array("orange","apple","kiwi","banana","strawberry","pine"), "banana")
   * next statement is Polymorphic (not typed) function, works with any "A" type
   *    var position = findFirst(Array("orange","apple","kiwi","banana","strawberry","pine"), (k:String)=> k=="banana")
   * so, if we want to try with an Int type, we don't need to change anything in the function:
   *    var position = findFirst(Array(9,11,33,7,5,2,31,70), (k:Int)=> k==97)
   */
  //var position = findFirst(Array(9,11,33,7,5,2,31,70), (k:Int)=> k==97)
  //println("searching key in array: ", position)

  def factorial(n: Int): Int = {
    def go(n: Int, acc: Int): Int ={
      if (n<=0) acc
      else go(n-1,acc*n)
    }
    go(n,1)
  }

  def fibonacci(n: Int): Int = {
    def go(count: Int, val1: Int, val2: Int): Int = {
      if (count==n) val1
      else go(count+1, val2, val1+val2)
    }
    go(1,0,1)
  }

  /*
  def findFirst(a:Array[String], k:String): Int = {
    @tailrec
    def loop(i: Int): Int={
      if (i>=a.length) -1
      else if(a(i)==k) i
      else loop(i+1)
    }
    loop(0)
  }
  */
  def findFirst[A](a:Array[A], k:A => Boolean): Int = {
    @tailrec
    def loop(i: Int): Int={
      if (i >= a.length) -1
      else if(k(a(i))) return i
      else loop(i+1)
    }
    loop(0)
  }

  //var sorted = isSorted(Array(9,11,33,7,5,2,31,70), (v1:Int, v2:Int) => v1>=v2)
  // var sorted = isSorted(Array(9,11,33,47,5,62,91,170), (v1:Int, v2:Int) => v1>=v2)
  // println("is sorted the array: ", sorted)

  def isSorted[A](a:Array[A], ordered: (A,A)=>Boolean): Boolean = {
    @tailrec
    def loop(i: Int): Boolean = {
      if (i>=a.length) true
      else if(ordered(a(i-1),a(i))) false
      else loop(i+1)
    }
    loop(1)
  }

  def curry[A,B,C](f: (A, B) => C): A => (B => C) =
    (a: A) => (b: B) => f(a,b)

  def uncurry[A,B,C](f: A => B => C): (A, B) => C =
    (a: A, b: B) => f(a)(b)

  def compose[A,B,C](f: B => C, g: A => B): A => C =
    (a: A) => f(g(a: A))

  println("The result is: ", miSum(List(1,2,3,4,5,6,7,8,9,10)))

  def miSum(list: List[Int]): Int = {
    List.sum(list)
  }

  // excercise:
  val x = List(1,2,3,4,5) match {
    case Cons(x, Cons(2, Cons(4, _))) => x
    case Nil => 42
    case Cons(x, Cons(y, Cons(3, Cons(4, _)))) => x + y
    case Cons(h, t) => h + sum(t)
    case _ => 101
  }
}
