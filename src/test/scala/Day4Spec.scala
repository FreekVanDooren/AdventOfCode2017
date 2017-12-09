import org.scalatest.FunSuite

class Day4Spec extends FunSuite {

  test("Example  1") {
    assert(Day4.nrOfValidPassPhrases(FileReader.getSource("day4/example1.txt")) == 2)
  }

  test("Actual  1") {
    assert(Day4.nrOfValidPassPhrases(FileReader.getSource("day4/actual.txt")) == 466)
  }

  test("Example  2") {
    assert(Day4.nrOfValidPassPhraseAnagrams(FileReader.getSource("day4/example2.txt")) == 3)
  }

  test("Actual  2") {
    assert(Day4.nrOfValidPassPhraseAnagrams(FileReader.getSource("day4/actual.txt")) == 251)
  }

}
