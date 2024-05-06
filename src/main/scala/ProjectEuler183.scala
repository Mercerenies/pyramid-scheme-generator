
package com.mercerenies.pyramids

import scala.language.implicitConversions

object ProjectEuler183 {
  import Code.*

  // Variables we use
  val sum = Var("sum")
  val a = Var("a")
  val b = Var("b")
  val x = Var("x")
  val y = Var("y")
  val n = Var("n")
  val k = Var("k")
  val recip = Var("recip")
  val tmp = Var("tmp")
  val denom = Var("denom")
  val twomod = Var("twomod")
  val fivemod = Var("fivemod")

  def e: Double = 2.718281828

  def code: Triangle =
    begin(
      sum := 0,
      x := 1,
      n := 5,
      loop(
        n < 101,
        begin(
          loop(
            e * (x + 1) < n,
            x := x + 1
          ),
          y := x + 1,
          recip := 1 / x,
          k := y,
          ifStmt(
            (y * (y ^ recip)) / (n ^ recip) > x,
            k := x,
          ),
          // GCD calculation
          a := n,
          b := k,
          loop(
            not(b =:= 0),
            begin(
              tmp := a,
              a := b,
              loop(
                tmp >= b,
                tmp := tmp - b,
              ),
              b := tmp,
            ),
          ),
          denom := k / a,
          // Remove powers of 2
          loop(
            begin(
              twomod := denom,
              loop(
                twomod > 19,
                twomod := twomod - 20,
              ),
              loop(
                twomod > 1,
                twomod := twomod - 2,
              ),
              twomod =:= 0,
            ),
            denom := denom / 2,
          ),
          // Remove powers of 5
          loop(
            begin(
              fivemod := denom,
              loop(
                fivemod > 49,
                fivemod := fivemod - 50,
              ),
              loop(
                fivemod > 4,
                fivemod := fivemod - 5,
              ),
              fivemod =:= 0,
            ),
            denom := denom / 5,
          ),
          // Add to sum
          ifStmt(
            denom =:= 1,
            sum := sum - n,
          ),
          ifStmt(
            not(denom =:= 1),
            sum := sum + n,
          ),
          n := n + 1,
        ),
      ),
      out(sum, chr(10)),
    )
}
