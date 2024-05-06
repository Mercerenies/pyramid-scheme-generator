
package com.mercerenies.pyramids

import scala.language.implicitConversions

// Helpers for writing Pyramid Scheme code.
object Code {
  export Functions.*

  def set(name: String, value: TriangleMagnet): Triangle =
    Node("set", Leaf(name), Some(value.toTriangle))

  def begin(body: Triangle*): Triangle =
    beginBlock(body)

  def beginBlock(body: Seq[Triangle]): Triangle =
    body.length match {
      case 0 => throw new Exception("Attempt to create empty 'begin' block")
      case 1 => body(0)
      case _ =>
        val (a, b) = body.splitAt(body.length / 2)
        rightBr(beginBlock(a), beginBlock(b))
    }

  def lessThan(a: TriangleMagnet, b: TriangleMagnet): Triangle =
    eq(cmp(a, b), -1)

  def greaterThan(a: TriangleMagnet, b: TriangleMagnet): Triangle =
    eq(cmp(a, b), 1)

  def lessOrEqual(a: TriangleMagnet, b: TriangleMagnet): Triangle =
    not(greaterThan(a, b))

  def greaterOrEqual(a: TriangleMagnet, b: TriangleMagnet): Triangle =
    not(lessThan(a, b))

  def notEq(a: TriangleMagnet, b: TriangleMagnet): Triangle =
    not(eq(a, b))

  // Extension methods for infix-ish operators.

  extension (a: String)
    def :=(b: TriangleMagnet): Triangle =
      set(a, b)

  extension (a: TriangleMagnet)
    def =:=(b: TriangleMagnet): Triangle =
      eq(a, b)
    def <(b: TriangleMagnet): Triangle =
      lessThan(a, b)
    def >(b: TriangleMagnet): Triangle =
      greaterThan(a, b)
    def <=(b: TriangleMagnet): Triangle =
      lessOrEqual(a, b)
    def >=(b: TriangleMagnet): Triangle =
      greaterOrEqual(a, b)
}
