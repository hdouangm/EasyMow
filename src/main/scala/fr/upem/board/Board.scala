package fr.upem.board

import fr.upem.coordinate.Coordinate
import fr.upem.mower.Mower

/**
  * Created by Hugo on 04/01/2019.
  */

final case class Board(coordinate: Coordinate, mowers: List[Mower]) {}

object Board {
  def validCoordinate(coordinate: Coordinate, mowers: List[Mower]): Boolean = {
    for (elem <- mowers){
      if (coordinate.posX == elem.coordinate.posX && coordinate.posY == elem.coordinate.posY){
        println("error : mowers can't be at the same place ! Skipping to next instruction if possible !")
        return false
      }

    }
    true
  }
}

