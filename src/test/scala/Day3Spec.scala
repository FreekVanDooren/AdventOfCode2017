import org.scalatest.FunSuite

import scala.io.Source

class Day3Spec extends FunSuite {

  test("Example from square 1") {
    assert(Day3.shortestWayBack(1) == 0)
  }

  test("Example from square 12") {
    assert(Day3.shortestWayBack(12) == 3)
  }

  test("Example from square 23") {
    assert(Day3.shortestWayBack(23) == 2)
  }

  test("Example from square 1024") {
    assert(Day3.shortestWayBack(1024) == 31)
  }

  test("Actual from square 368078") {
    assert(Day3.shortestWayBack(368078) == 371)
  }

  test("Example largest after 1") {
    assert(Day3.spiralToLargestAfter(1) == 2)
  }

  test("Example largest after 2") {
    assert(Day3.spiralToLargestAfter(2) == 4)
  }

  test("Example largest after 3") {
    assert(Day3.spiralToLargestAfter(3) == 4)
  }

  test("Example largest after 352") {
    assert(Day3.spiralToLargestAfter(352) == 362)
  }

  test("Actual largest after 368078") {
    assert(Day3.spiralToLargestAfter(368078) == 369601)
  }
}
