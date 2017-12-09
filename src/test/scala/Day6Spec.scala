import org.scalatest.FunSuite

class Day6Spec extends FunSuite {

  val EXAMPLE = List(0, 2, 7, 0)
  val ACTUAL = List(11, 11, 13, 7, 0, 15, 5, 5, 4, 4, 1, 1, 7, 1, 15, 11)

  test("Example  1") {
    assert(Day6.memoryAllocationRecycles(EXAMPLE) == 5)
  }

  test("Actual  1") {
    assert(Day6.memoryAllocationRecycles(ACTUAL) == 4074)
  }

  test("Example  2") {
    assert(Day6.memoryAllocationCycleDistance(EXAMPLE) == 4)
  }

  test("Actual  2") {
    assert(Day6.memoryAllocationCycleDistance(ACTUAL) == 2793)
  }

}
