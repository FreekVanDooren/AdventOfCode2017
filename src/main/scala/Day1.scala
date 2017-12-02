object Day1 {

  def inverseCaptchaHalf(input: String) = {
    val characters = input.toList
    val nrOfCharaters = characters.size
    val halfWay = nrOfCharaters/2
    sum(characters
      .zipWithIndex
      .map {
        case (character, index) if index < halfWay => List(character, characters(index + halfWay))
        case (character, index) if index >= halfWay => List(character, characters(index - halfWay))
      })
  }

  def inverseCaptcha(input: String): Int = {
    sum((input + input.charAt(0)).toList
      .sliding(2))
  }

  private def sum(input:TraversableOnce[List[Char]]) = {
    input
      .map {
        case List(a, b) if a == b => a
        case _ => '0'
      }
      .map(_.toInt - '0')
      .reduce(_ + _)
  }
}


