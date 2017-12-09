import scala.io.BufferedSource

object Day4 {

  def nrOfValidPassPhraseAnagrams(source: BufferedSource):Int = {
      read(source).count(phrase =>
        phrase.map(_.sorted).distinct.size == phrase.size
      )
  }

  def nrOfValidPassPhrases(source: BufferedSource): Int = {
    read(source).count(phrase =>
      phrase.size == phrase.distinct.size
    )
  }

  private def read(source: BufferedSource) = {
    source.getLines().map {
      _.split(" ")
    }
  }
}
