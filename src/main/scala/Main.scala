
package com.mercerenies.pyramids

import java.nio.file.{Paths, Files}
import java.nio.charset.StandardCharsets

@main def main(): Unit = {
  val g = Grid()
  ProjectEuler183.code.draw(g, Point(0, 0))
  val bytes = g.lines.mkString("\n").getBytes(StandardCharsets.UTF_8)
  Files.write(Paths.get("problem183.pyra"), bytes)
}
