import org.scalatest.FunSuite

class Day12Spec extends FunSuite {

  val example = List(
    "0 <-> 2",
    "1 <-> 1",
    "2 <-> 0, 3, 4",
    "3 <-> 2, 4",
    "4 <-> 2, 3, 6",
    "5 <-> 6",
    "6 <-> 4, 5"
  )
  test("Example  1.1") {
    assert(Day12.nrWithProgram0(example) == 6)
  }

  test("Actual 1") {
    assert(Day12.nrWithProgram0(FileReader.getSource("day12/actual.txt").getLines.toList) == 288)
  }

  test("Example  2.1") {
    assert(Day12.nrOfGroups(example) == 2)
  }

  test("Actual 2") {
    assert(Day12.nrOfGroups(FileReader.getSource("day12/actual.txt").getLines.toList) == 211)
  }
}
