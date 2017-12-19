import org.scalatest.FunSuite

class Day11Spec extends FunSuite {

  test("Example  1.1") {
    assert(Day11.hexStepsAway("ne,ne,ne") == 3)
  }

  test("Example  1.2") {
    assert(Day11.hexStepsAway("ne,ne,sw,sw") == 0)
  }

  test("Example  1.3") {
    assert(Day11.hexStepsAway("ne,ne,s,s") == 2)
  }

  test("Example  1.4") {
    assert(Day11.hexStepsAway("se,sw,se,sw,sw") == 3)
  }

  test("Actual 1") {
    assert(Day11.hexStepsAway(FileReader.getSource("day11/actual.txt").getLines.toList(0)) == 664)
  }

  test("Example  2.1") {
    assert(Day11.maxHexStepsWay("ne,ne,ne") == 3)
  }

  test("Example  2.2") {
    assert(Day11.maxHexStepsWay("ne,ne,sw,sw") == 2)
  }

  test("Example  2.3") {
    assert(Day11.maxHexStepsWay("ne,ne,s,s") == 2)
  }

  test("Example  2.4") {
    assert(Day11.maxHexStepsWay("se,sw,se,sw,sw") == 3)
  }

  test("Actual 2") {
    assert(Day11.maxHexStepsWay(FileReader.getSource("day11/actual.txt").getLines.toList(0)) == 1447)
  }
}
