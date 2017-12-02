import scala.collection.immutable._
import scala.io.BufferedSource

object Day2 {

  implicit class BufferedSourceExtra(source: BufferedSource) {
    def asMatrix = {
      source.getLines()
        .map {
          _.split("\\s")
            .map(_.toInt)
            .toList
        }
    }

  }

  def minMaxDifference(source: BufferedSource): Int = {
    source.asMatrix
      .map(x => List(x.max, x.min))
      .map(_.reduce(_ - _))
      .sum
  }

  def division(source: BufferedSource): Int = {
    source.asMatrix
      .flatMap {
        _.combinations(2)
          .map {
            _ match {
              case List(a, b) if a % b == 0 => a / b
              case List(a, b) if b % a == 0 => b / a
              case _ => 0
            }
          }
      }.sum
  }
}
