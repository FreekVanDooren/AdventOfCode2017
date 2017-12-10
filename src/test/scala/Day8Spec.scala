import org.scalatest.FunSuite

class Day8Spec extends FunSuite {

  test("Example  1") {
    assert(Day8.highestInRegister(FileReader.getSource("day8/example.txt")) == 1)
  }

  test("Actual  1") {
    assert(Day8.highestInRegister(FileReader.getSource("day8/actual.txt")) == 5752)
  }

  test("Example  2") {
    assert(Day8.highestEverInRegister(FileReader.getSource("day8/example.txt")) == 10)
  }

  test("Actual  2") {
    assert(Day8.highestEverInRegister(FileReader.getSource("day8/actual.txt")) == 6366)
  }
}
