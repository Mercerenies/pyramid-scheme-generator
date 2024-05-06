
package com.mercerenies.pyramids

case class Point(val x: Int, val y: Int) {

  def +(that: Point) = Point(this.x + that.x, this.y + that.y)

  def unary_- = Point(- this.x, - this.y)

  def -(that: Point) = this + -that

  def in(ul: Point, lr: Point) =
    this.x >= ul.x && this.y >= ul.y &&
    this.x < lr.x && this.y < lr.y

}

object Point {

  val zero = Point(0, 0)

  def min(a: Point, b: Point) =
    Point(math.min(a.x, b.x), math.min(a.y, b.y))

  def max(a: Point, b: Point) =
    Point(math.max(a.x, b.x), math.max(a.y, b.y))

}
