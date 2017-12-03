import org.scalatest.FunSuite

import scala.io.Source

class Day3Spec extends FunSuite {

  test("Example square 1") {
    assert(Day3.spiralMemoryTrace(1) == 0)
  }

  test("Example square 12") {
    assert(Day3.spiralMemoryTrace(12) == 3)
  }

  test("Example square 23") {
    assert(Day3.spiralMemoryTrace(1) == 2)
  }

  test("Example square 1024") {
    assert(Day3.spiralMemoryTrace(1) == 31)
  }

  test("Actual 368078") {
    assert(Day3.spiralMemoryTrace(368078) == 0)
  }
}
