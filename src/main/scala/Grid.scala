
package com.mercerenies.pyramids

import scala.collection.mutable.HashMap
import scala.language.postfixOps

class Grid {
  private val impl: HashMap[Point, Char] = HashMap()

  export impl.update

  def apply(p: Point): Char =
    impl.getOrElse(p, ' ')

  def xMin: Int = if (impl.isEmpty) { 0 } else { impl.keys.map(_.x).min }
  def xMax: Int = if (impl.isEmpty) { 0 } else { impl.keys.map(_.x).max }
  def yMin: Int = if (impl.isEmpty) { 0 } else { impl.keys.map(_.y).min }
  def yMax: Int = if (impl.isEmpty) { 0 } else { impl.keys.map(_.y).max }

  def lines: List[String] =
    yMin to yMax map { y =>
      xMin to xMax map { x => this(Point(x, y)) } mkString
    } toList

  def print(): Unit = lines foreach println
}

object Grid {

  extension (self: Grid)
    def drawTriangle(origin: Point, height: Int, body: String): Unit = {
      self(origin) = '^'
      1 to (height - 1) foreach { z =>
        self(origin + Point(z, z)) = '\\'
        self(origin + Point(- z, z)) = '/'
      }
      (- (height - 1)) to (height - 1) foreach { x =>
        self(origin + Point(x, height)) = '-'
      }
      val textOrigin = Point(- body.length / 2, height - 1)
      body.zipWithIndex foreach { case (c, i) =>
        self(origin + textOrigin + Point(i, 0)) = c
      }
    }

}
