object Day11 {

  def length(coordinate: Coordinate) = {
    (math.abs(coordinate.x) + math.abs(coordinate.y) + math.abs(coordinate.z)) / 2
  }

  def hexStepsAway(input: String) = {
    length(toCoordinateDeltas(input).last)
  }

  private def toCoordinateDeltas(input: String) = {
    input.split(",")
      .map(_ match {
        case "n" => Delta(0, 1, -1)
        case "ne" => Delta(-1, 1, 0)
        case "se" => Delta(-1, 0, 1)
        case "s" => Delta(0, -1, 1)
        case "sw" => Delta(1, -1, 0)
        case "nw" => Delta(1, 0, -1)
      })
      .foldLeft(List[Coordinate](Coordinate(0, 0, 0))) {(coordinates, delta) =>
        val current = coordinates.last
        coordinates :+ Coordinate(current.x + delta.x, current.y + delta.y, current.z + delta.z)
      }
  }

  def maxHexStepsWay(input: String) = {
    toCoordinateDeltas(input).map(length).max
  }

}

case class Coordinate(x: Int, y: Int, z: Int)
case class Delta(x: Int, y: Int, z: Int)