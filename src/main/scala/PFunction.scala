
package com.mercerenies.pyramids

abstract class PFunction {
  def name: String
  def minArity: Int
  def maxArity: Int
}

case class PFunction1(override val name: String) extends PFunction {
  override def minArity = 1
  override def maxArity = 1

  def apply(a: Triangle): Triangle =
    Node(name, a, None)
}

case class PFunction2(override val name: String) extends PFunction {
  override def minArity = 2
  override def maxArity = 2

  def apply(a: Triangle, b: Triangle): Triangle =
    Node(name, a, Some(b))
}

case class PFunctionBoth(override val name: String) extends PFunction {
  override def minArity = 1
  override def maxArity = 2

  def apply(a: Triangle): Triangle =
    Node(name, a, None)
  def apply(a: Triangle, b: Triangle): Triangle =
    Node(name, a, Some(b))
}
