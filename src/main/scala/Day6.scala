import java.util.Arrays.copyOfRange

object Day6 {


  def recycle(locations: List[Int], historyHandler: List[List[Int]] => Int):Int = {

    def recycle(locations: List[Int], history: List[List[Int]]):Int = {
      val nextIndex: Int => Int = _ match {
        case i if i == locations.size - 1 => 0
        case i => i + 1
      }

      def cycle(locations: List[Int], currentValue: Int, position: Int):List[Int] = {
        if (currentValue == 0) {
          return locations
        }
        val newIndex = nextIndex(position);
        cycle(locations.slice(0,newIndex) ::: (locations(newIndex) + 1) :: locations.slice(newIndex + 1, locations.size),
          currentValue - 1,
          newIndex
        )
      }
      if (history.contains(locations)){
        return historyHandler(history.::(locations))
      }
      val maxValue = locations.max
      val maxIndex = locations.indexOf(maxValue)
      val cycledList = cycle(locations.slice(0,maxIndex) ::: 0 :: locations.slice(maxIndex + 1, locations.size)
        , maxValue, maxIndex)
      recycle(cycledList, history.::(locations))
    }
    recycle(locations, List())

  }

  def memoryAllocationRecycles(locations: List[Int]):Int = {
    recycle(locations, _.size - 1)
  }

  def memoryAllocationCycleDistance(locations: List[Int]):Int = {
    recycle(locations, history => history.lastIndexOf(history(0)))
  }

}
