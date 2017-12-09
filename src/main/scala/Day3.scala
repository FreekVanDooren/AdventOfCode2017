

object Day3 {

  def shortestWayBack(n: Int): Int = {
    if (n <= 1) {
      return 0
    }
    val elementNr = n - 1
    val radius = Math.ceil((Math.sqrt(elementNr) - 1) / 2).toInt
    val nrOfPointsOnCurrentCircle = radius * 8
    val nrOfPointsBeforeCurrentCircle = nrOfPointsOnCurrentCircle * (radius - 1) / 2

    val shiftedPosition = elementNr - nrOfPointsBeforeCurrentCircle
    val nrOfPointsOnFace = radius * 2
    val positionOnSide = shiftedPosition % nrOfPointsOnFace
    val coordinates = Math.floor(shiftedPosition / nrOfPointsOnFace).toInt match {
      // right:
      case 0 => (radius, positionOnSide - radius)
      // top:
      case 1 => (positionOnSide - radius, radius)
      // left:
      case 2 => (-radius, radius - positionOnSide)
      // bottom:
      case 3 => (radius - positionOnSide, -radius )
    }
    Math.abs(coordinates._1) + Math.abs(coordinates._2)
  }

  def spiralToLargestAfter(input: Int): Int = {
    0
  }

}
