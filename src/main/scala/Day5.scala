import java.util.Arrays.copyOfRange

import scala.annotation.tailrec
import scala.io.BufferedSource

object Day5 {

  implicit class FastSlicer(val a: Array[Int]) {
    def fastSlice(from: Int, until: Int)  = copyOfRange(a, from, until)
  }

  def regularStepsOutOfMaze(source: BufferedSource): Int = {
    stepsOutOfmaze(source, _ + 1)
  }

  def quirkyRegularStepsOutOfMaze(source: BufferedSource): Int = {
    stepsOutOfmaze(source, _ match {
      case i if i >= 3 => i -1
      case i => i + 1
    })
  }

  private def stepsOutOfmaze(source: BufferedSource, shifter: Int => Int) = {
    @tailrec
    def stepsOutOfMaze(instructions: Array[Int], position: Int, counter: Int): Int = {
      if (position < 0 || position >= instructions.size)
        return counter
      val shift: Int = instructions(position)
      stepsOutOfMaze(instructions.fastSlice(0, position) ++
        Array(shifter(shift)) ++
        instructions.fastSlice(position + 1, instructions.size)
        , shift + position, counter + 1)

    }

    stepsOutOfMaze(source.getLines().map(_.toInt).toArray, 0, 0)
  }
}
