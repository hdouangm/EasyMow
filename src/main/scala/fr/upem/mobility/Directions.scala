package fr.upem.mobility

/**
  * Created by Hugo on 05/01/2019.
  */
object Directions {
  sealed trait Direction
  case object G extends Direction
  case object D extends Direction
}
