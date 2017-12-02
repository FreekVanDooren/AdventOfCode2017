object Day1 {

  implicit class MakeSummable(input: TraversableOnce[List[Char]]) {
    def filterAndSum = {
      input
        .filter {
          case List(a, b) => a == b
        }
        .map {
          case List(a, b) => a
        }
        .map(_.toInt - '0')
        .sum
    }
  }

  def inverseCaptchaHalf(input: String) = {
    val characters = input.toList
    val halfWay = characters.size / 2
    characters
      .zipWithIndex
      .map {
        case (character, index) if index < halfWay => List(character, characters(index + halfWay))
        case (character, index) if index >= halfWay => List(character, characters(index - halfWay))
      }.filterAndSum
  }

  def inverseCaptcha(input: String): Int = {
    (input + input.charAt(0)).toList
      .sliding(2)
      .filterAndSum
  }
}


