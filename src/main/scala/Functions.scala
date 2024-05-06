
package com.mercerenies.pyramids

object Functions {
  val eq = PFunction2("=")
  val cmp = PFunction2("<=>")
  val plus = PFunction2("+")
  val minus = PFunction2("-")
  val times = PFunction2("*")
  val div = PFunction2("/")
  val power = PFunction2("^")
  val out = PFunctionBoth("out")
  val chr = PFunction1("chr")
  val leftBr = PFunction2("[")
  val rightBr = PFunction2("]")
}