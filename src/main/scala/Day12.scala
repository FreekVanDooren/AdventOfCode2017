object Day12 {

  def group(pipes: List[Pipe], groups: List[List[Pipe]]): List[List[Pipe]] = {
    if (pipes.isEmpty) {
      return groups
    }
    val firstPipe = pipes(0)
    val idsInGroup = pipeIdsInGroup(pipes, firstPipe.ids, firstPipe.id).toList
    val isInGroup: Pipe => Boolean = x => idsInGroup.contains(x.id)
    group(pipes.filterNot(isInGroup), groups :+ pipes.filter(isInGroup))
  }

  def nrOfGroups(input: List[String]):Int = {
    val pipes = toPipes(input)
    val groups: List[List[Pipe]] = group(pipes, Nil)
    groups.size
  }


  def isWithDenominator(pipes: List[Pipe], with0: List[String], denominator: String):Traversable[String] = {
    if (pipes.isEmpty) {
      return with0.toSet
    }
    isWithDenominator(pipes.tail, with0 ::: (pipes.head match {
      case pipe if pipe.ids.contains(denominator) => pipe.id :: pipe.ids
      case pipe if with0.exists((pipe.id :: pipe.ids).contains) => pipe.id :: pipe.ids
      case _ => Nil
    }), denominator)
  }

  def nrWithProgram0(input: List[String]): Int = {
    val pipes = toPipes(input)
    pipeIdsInGroup(pipes, pipes(0).ids, "0").size
  }

  private def toPipes(programPipes: List[String]) = {
    programPipes.map(listing => {
      val splits = listing.split("\\s<->\\s")
      Pipe(splits(0), splits(1).split(",\\s").toList)
    })
  }

  private def pipeIdsInGroup(pipes: List[Pipe], intermediate: List[String], denominator: String):Traversable[String] = {
    val withDenominator = isWithDenominator(pipes.tail, intermediate, denominator)

    if (intermediate.size == withDenominator.size)
      return withDenominator
    pipeIdsInGroup(pipes, withDenominator.toList, denominator)
  }
}

case class Pipe(id: String, ids: List[String])