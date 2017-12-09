import scala.io.BufferedSource

object Day7 {

  def bottomProgram(source: BufferedSource): String = {
    asProgramsWithParents(source)
      .find(_.parent == null)
      .get.program.name
  }


  def correctedWeight(source: BufferedSource): Int = {
    val programsWithParents = asProgramsWithParents(source)
    val withChildren = programsWithParents
      .map(program =>
        ProgramWithChildren(program, programsWithParents
          .filter(programWithParents =>
            program.program.carrying.contains(programWithParents.program.name)
          )
        )
      )

    def findChildWeights(program: ProgramWithChildren): List[Int] = {
      program match {
        case prog if prog.children.isEmpty => List(prog.program.program.weight)
        case prog =>
          prog.program.program.weight :: prog.children.map(x =>
            withChildren.filter(y => x.program.name.equals(y.program.program.name)).flatMap(z => findChildWeights(z)).sum
          )
      }
    }

    withChildren
      .map(program => findChildWeights(program))
      .zipWithIndex
      .find {
        case entry => entry._1 match {
          case x :: childWeights => !childWeights.isEmpty && childWeights.distinct.size != 1
        }
      }
      .map(tuple => {
        val divergentWeight = tuple._1 match {
          case x :: weights if (weights.count(_ == weights.min) > 1) => weights.max
          case x :: weights => weights.min
        }
        val weightDifference = tuple._1 match {
          case x :: weights => weights.max - weights.min
        }
        val index = tuple._1.indexOf(divergentWeight) - 1
        withChildren(tuple._2).children(index).program.weight - weightDifference
      }
      ).get
  }

  private def asProgramsWithParents(source: BufferedSource): List[ProgramWithParent] = {
    val programs = source.getLines().map(line => {
      val firstParts = line.split("\\s\\(")
      val secondParts = firstParts(1).split("\\)(\\s->\\s)?")
      val carrying = if (secondParts.size == 2) secondParts(1).split(",\\s").toList else List()
      Program(firstParts(0), secondParts(0).toInt, carrying)
    }).toList

    programs
      .map(current => ProgramWithParent(current, programs.find(program => program.carrying.contains(current.name)).orNull))
  }
}

case class Program(name: String, weight: Int, carrying: List[String])

case class ProgramWithParent(program: Program, parent: Program)

case class ProgramWithChildren(program: ProgramWithParent, children: List[ProgramWithParent])