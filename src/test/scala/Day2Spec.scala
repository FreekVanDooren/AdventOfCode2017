import org.scalatest.FunSuite

import scala.io.Source

class Day2Spec extends FunSuite {

  test("Example Min Max difference") {
    assert(Day2.minMaxDifference(getSource("day2/example_min_max_diff.txt")) == 18)
  }

  test("Actual Min Max Difference") {
    assert(Day2.minMaxDifference(getSource("day2/actual.txt")) == 30994)
  }

  test("Example Division") {
    assert(Day2.division(getSource("day2/example_division.txt")) == 9)
  }

  test("Actual Division") {
    assert(Day2.division(getSource("day2/actual.txt")) == 233)
  }

  private def getSource(fileName: String) = {
    Source.fromInputStream(getClass.getResourceAsStream(fileName))
  }
}
