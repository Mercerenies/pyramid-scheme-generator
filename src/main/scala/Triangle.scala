
package com.mercerenies.pyramids

sealed abstract class Triangle {
  def totalHeight: Int
  def myHeight: Int
}

object Triangle {

  def minHeightForText(text: String): Int =
    text.length / 2 + 2

}

case class Leaf(
  val value: Double,
) extends Triangle {

  val myHeight = Triangle.minHeightForText(value.toString)
  def totalHeight = myHeight

}

case class Node(
  val function: String,
  val left: Triangle,
  val right: Triangle,
) extends Triangle {
  val myHeight = math.max(
    Triangle.minHeightForText(function),
    // This is just some basic geometry. Draw it out. This is the
    // minimum value of myHeight that will ensure the two children do
    // NOT intersect when drawn. It's an isosceles triangle with one
    // 90 degree angle and the others 45 degrees. :)
    math.min(left.totalHeight, right.totalHeight) + 1,
  )
  val totalHeight = myHeight + math.max(left.myHeight, right.myHeight)
}
