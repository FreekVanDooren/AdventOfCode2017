import org.scalatest.FunSuite

class Day9Spec extends FunSuite {

  val ACTUAL = FileReader.getSource("day9/actual.txt").getLines().reduce(_ + _)

  test("Example  1.1") {
    assert(Day9.nestingScore("{}") == 1)
  }

  test("Example  1.2") {
    assert(Day9.nestingScore("{{{}}}") == 6)
  }

  test("Example  1.3") {
    assert(Day9.nestingScore("{{},{}}") == 5)
  }

  test("Example  1.4") {
    assert(Day9.nestingScore("{{{},{},{{}}}}") == 16)
  }

  test("Example  1.4.5") {
    assert(Day9.nestingScore("{{{},{},{{}},{}},{}}") == 21)
  }

  test("Example  1.5") {
    assert(Day9.nestingScore("{<a>,<a>,<a>,<a>}") == 1)
  }

  test("Example  1.6") {
    assert(Day9.nestingScore("{{<ab>},{<ab>},{<ab>},{<ab>}}") == 9)
  }

  test("Example  1.7") {
    assert(Day9.nestingScore("{{<!!>},{<!!>},{<!!>},{<!!>}}") == 9)
  }

  test("Example  1.8") {
    assert(Day9.nestingScore("{{<a!>},{<a!>},{<a!>},{<ab>}}") == 3)
  }

  test("Actual  1") {
    assert(Day9.nestingScore(ACTUAL) == 15922)
  }

  test("Example  2.1") {
    assert(Day9.garbageCount("<>") == 0)
  }

  test("Example  2.2") {
    assert(Day9.garbageCount("<random characters>") == 17)
  }

  test("Example  2.3") {
    assert(Day9.garbageCount("<<<<>") == 3)
  }

  test("Example  2.4") {
    assert(Day9.garbageCount("<{!>}>") == 2)
  }

  test("Example  2.5") {
    assert(Day9.garbageCount("<!!>") == 0)
  }

  test("Example  2.6") {
    assert(Day9.garbageCount("<!!!>>") == 0)
  }

  test("Example  2.7") {
    assert(Day9.garbageCount("<{o\"i!a,<{i<a>") == 10)
  }

  test("Actual  2") {
    assert(Day9.garbageCount(ACTUAL) == 7314)
  }
}
