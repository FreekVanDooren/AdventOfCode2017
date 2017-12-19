import org.scalatest.FunSuite

class Day10Spec extends FunSuite {

  val EXAMPLE = List(3, 4, 1, 5)
  val ACTUAL = "225,171,131,2,35,5,0,13,1,246,54,97,255,98,254,110"

  test("Example  1.1") {
    assert(Day10.cycleHash(EXAMPLE, 0 to 4) == 12)
  }

  test("Actual  1") {
    assert(Day10.cycleHash(ACTUAL.split(",").toList.map(_.toInt), 0 to 255) == 23874)
  }

  test("Example 2.1") {
    assert(Day10.knotHash("") == "a2582a3a0e66e6e86e3812dcb672a272")
  }

  test("Example 2.2") {
    assert(Day10.knotHash("AoC 2017") == "33efeb34ea91902bb2f59c9920caa6cd")
  }

  test("Example 2.3") {
    assert(Day10.knotHash("1,2,3") == "3efbe78a8d82f29979031a4aa0b16a9d")
  }

  test("Example 2.4") {
    assert(Day10.knotHash("1,2,4") == "63960835bcdc130f0b66d7ff4f6a5a8e")
  }

  test("Actual 2") {
    assert(Day10.knotHash(ACTUAL) == "e1a65bfb5a5ce396025fab5528c25a87")
  }
}
