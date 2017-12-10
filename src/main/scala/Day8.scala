import java.util.function.Predicate

import scala.io.BufferedSource

object Day8 {
  def highestEverInRegister(source: BufferedSource) = {
    val (registry: Set[Register], values: List[Int]) = goThroughRegistry(source)
    values.max
  }

  def highestInRegister(source: BufferedSource): Int = {
    val (registry: Set[Register], values: List[Int]) = goThroughRegistry(source)
    registry.map(_.value).max
  }

  private def goThroughRegistry(source: BufferedSource) = {
    val instructions = source.getLines()
      .map { line =>
        val strings = line.split("\\s")
        val incrementValue = strings(2).toInt
        val predicateName = strings(4)
        val predicateValue = strings(6).toInt
        Instruction(
          strings(0), strings(1) match {
            case "inc" => (x: Int) => x + incrementValue
            case "dec" => (x: Int) => x - incrementValue
          }, strings(5) match {
            case ">" => (x: Register) => x.name == predicateName && x.value > predicateValue
            case "<" => (x: Register) => x.name == predicateName && x.value < predicateValue
            case ">=" => (x: Register) => x.name == predicateName && x.value >= predicateValue
            case "<=" => (x: Register) => x.name == predicateName && x.value <= predicateValue
            case "==" => (x: Register) => x.name == predicateName && x.value == predicateValue
            case "!=" => (x: Register) => x.name == predicateName && x.value != predicateValue
          })
      }.toList
    var values = List(0)
    val registry = instructions.map(instruction => Register(instruction.registerName, 0)).toSet
    instructions.foreach(instruction =>
      if (registry.find(instruction.predicate).nonEmpty) {
        registry.find(_.name == instruction.registerName).map(current => {
          current.value = instruction.func(current.value)
          values = values :+ current.value
        }
        ).toList
      }
    )
    (registry, values)
  }
}

case class Instruction(registerName: String, func: Function[Int, Int], predicate: Function[Register, Boolean])
case class Register(name: String, var value: Int)