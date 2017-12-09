import scala.io.Source

object FileReader {

  def getSource(fileName: String) = {
    Source.fromInputStream(getClass.getResourceAsStream(fileName))
  }

}
