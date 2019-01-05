package fr.upem.mobility

/**
  * Created by Hugo on 05/01/2019.
  */
object Directions {
  sealed trait Direction
  case object G extends Direction
  case object D extends Direction
  case object A extends Direction

  def toDirection(s: String): Option[Direction] ={
    s match {
      case "G" => Option(G)
      case "D" => Option(D)
      case "A" => Option(A)
      case _ => Option.empty
    }
  }
}
