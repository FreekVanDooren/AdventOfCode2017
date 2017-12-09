import org.scalatest.FunSuite

class Day5Spec extends FunSuite {

  test("Example  1") {
    assert(Day5.regularStepsOutOfMaze(FileReader.getSource("day5/example1.txt")) == 5)
  }

  test("Actual  1") {
    assert(Day5.regularStepsOutOfMaze(FileReader.getSource("day5/actual.txt")) == 343467)
  }

  test("Example  2") {
    assert(Day5.quirkyRegularStepsOutOfMaze(FileReader.getSource("day5/example1.txt")) == 10)
  }

  test("Actual  2") {
    assert(Day5.quirkyRegularStepsOutOfMaze(FileReader.getSource("day5/actual.txt")) == 24774780)
  }

}
