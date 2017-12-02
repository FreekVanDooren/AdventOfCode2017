import scala.collection.immutable
import scala.io.BufferedSource

object Day2 {

  def minMaxDifference(source: BufferedSource): Int = {

    def min(value: List[Int]): Int = value match {
      case List(x: Int) => x
      case x :: y :: rest if x < y => min(x :: rest)
      case x :: y :: rest => min(y :: rest)
    }

    def max(value: List[Int]): Int = value match {
      case List(x: Int) => x
      case x :: y :: rest if x > y => max(x :: rest)
      case x :: y :: rest => max(y :: rest)
    }
    sum(asMatrix(source)
      .map(numbers => List(max(numbers), min(numbers)))
      .map(_.reduce(_ - _)))
  }

  def division(source: BufferedSource): Int = {
    val ints = asMatrix(source)
      .flatMap { x: immutable.Seq[Int] =>
        x.combinations(2).toList
          .filter {
            case List(a, b) if a > b => a % b == 0
            case List(a, b) if a < b => b % a == 0
            case _ => false
          }
          .map {
            _ match {
              case List(a, b) if a > b => a / b
              case List(a, b) if a < b => b / a
              case _ => 0
            }
          }
      }
    sum(ints)
  }

  private def asMatrix(source: BufferedSource) = {
    source.getLines()
      .map {
        _.split("\\s")
          .map(_.toInt)
          .toList
      }
  }

  private def sum(ints: Iterator[Int]) = {
    ints.reduce(_ + _)
  }
}
