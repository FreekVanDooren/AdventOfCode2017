import org.scalatest.FunSuite

class Day7Spec extends FunSuite {

  test("Example  1") {
    assert(Day7.bottomProgram(FileReader.getSource("day7/example.txt")) == "tknk")
  }

  test("Actual  1") {
    assert(Day7.bottomProgram(FileReader.getSource("day7/actual.txt")) == "mkxke")
  }

  test("Example  2") {
    assert(Day7.correctedWeight(FileReader.getSource("day7/example.txt")) == 60)
  }

  test("Actual  2") {
    assert(Day7.correctedWeight(FileReader.getSource("day7/actual.txt")) == 268)
  }
}
