
// Magnet pattern for Triangles. Makes it easier to embed floats in
// our pyramid without constantly having to Leaf(x.toString) them.

package com.mercerenies.pyramids

trait TriangleMagnet {
  def toTriangle: Triangle
}

object TriangleMagnet {

  given TriangleToTriangleMagnet: Conversion[Triangle, TriangleMagnet] with
    def apply(t: Triangle): TriangleMagnet = new TriangleMagnet {
      def toTriangle = t
    }

  given IntToTriangleMagnet: Conversion[Int, TriangleMagnet] with
    def apply(i: Int): TriangleMagnet = new TriangleMagnet {
      def toTriangle = Leaf(i.toString)
    }

  given DoubleToTriangleMagnet: Conversion[Double, TriangleMagnet] with
    def apply(d: Double): TriangleMagnet = new TriangleMagnet {
      def toTriangle = Leaf(d.toString)
    }

}
