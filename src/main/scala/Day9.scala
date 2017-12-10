object Day9 {

  def garbageCount(input: String): Int = {
    toIntRepresentation(input).foldLeft(List[Int](0)) { (filtered, x) =>
      filtered match {
        case y if x == -55 => y.dropRight(1) :+ 0
        case y if x == 55 => y :+ 1
        case y => y :+ y.last
      }
    }.sum
  }


  def nestingScore(input: String): Int = {
    toIntRepresentation(input).foldLeft(List[Int](0)) { (filtered, x) =>
      filtered match {
        case y if x == -55 => y.dropRight(1)
        case y if y.last == 55 => y
        case y => y :+ x
      }
    }.filter {
      _ != 0
    }.foldLeft(List[Int]()) { (sums, x) =>
      sums match {
        case List() => x :: Nil
        case y => y :+ (x + y.last)
      }
    }.sliding(2)
      .filter({ x => x(1) > x(0) }).foldLeft(List[Int](1)) { (cleanedSum: List[Int], x) =>
      cleanedSum :+ x(1)
    }.sum
  }

  private def toIntRepresentation(input: String) = {
    input.map(
      _ match {
        case '{' => 1
        case '}' => -1
        case '!' => 25
        case '<' => 55
        case '>' => -55
        case _ => 0
      }
    ).foldLeft(List[Int](0)) { (filtered, x) =>
      filtered match {
        case y if y.last == 25 => y.dropRight(1)
        case y => y :+ x
      }
    }
  }
}
