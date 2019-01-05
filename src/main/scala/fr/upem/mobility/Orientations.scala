package fr.upem.mobility

/**
  * Created by Hugo on 04/01/2019.
  */
object Orientations{
  sealed trait Orientation
  case object N extends Orientation
  case object E extends Orientation
  case object W extends Orientation
  case object S extends Orientation
}
