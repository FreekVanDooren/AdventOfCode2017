object Day10 {

  def takeReversedList(reversedList: List[Int], hashList: List[Int], currentPosition: Int, step: Int): List[Int] = {
    if (step == 0) {
      return reversedList
    }
    val position = currentPosition % hashList.size
    takeReversedList(hashList(position) :: reversedList, hashList, position + 1, step - 1)
  }

  def replaceAtPosition(reversedList: List[Int], hashList: List[Int], currentPosition: Int, step: Int): List[Int] = {
    if (step == 0) {
      return hashList
    }
    val position = currentPosition % hashList.size
    replaceAtPosition(reversedList.tail, hashList.updated(position, reversedList(0)), position + 1, step - 1)
  }

  def cycle(hashList: List[Int], steps: List[Int], currentPosition: Int, skipSize: Int): (List[Int], Int, Int) = {
    if (steps.isEmpty) {
      return (hashList, currentPosition, skipSize)
    }
    val step = steps(0)

    val reversedList: List[Int] = takeReversedList(List[Int](), hashList, currentPosition, step)
    val replacedList: List[Int] = replaceAtPosition(reversedList, hashList, currentPosition, step)

    val position = (currentPosition + step + skipSize) % hashList.size
    cycle(replacedList, steps.tail, position, skipSize + 1)
  }

  def cycleHash(steps: List[Int], range: Range.Inclusive):Int = {
    val tuple = cycle(range.toList, steps, 0, 0)
    tuple._1.take(2).reduce(_*_)
  }

  def sparseHash(hashList: List[Int], steps: List[Int], currentPosition: Int, skipSize: Int, counter: Int): List[Int] = {
    if (counter == 0) {
      return hashList
    }
    val cycled = cycle(hashList, steps, currentPosition, skipSize)
    sparseHash(cycled._1, steps, cycled._2, cycled._3, counter - 1)
  }

  def knotHash(input: String):String = {
    val steps: List[Int] = input.getBytes().toList.map(_.toInt) ::: List(17, 31, 73, 47, 23)
    val range = (0 to 255).toList

    sparseHash(range, steps, 0, 0, 64)
      .sliding(16, 16)
      .map((x: List[Int]) => x.reduce((t, s) => t ^ s)).map(_.toHexString match {
      case x if x.length == 1 => "0" + x
      case x => x
    }).mkString("")
  }

}
