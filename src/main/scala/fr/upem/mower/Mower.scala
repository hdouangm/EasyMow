package fr.upem.mower

/**
  * Created by Hugo on 04/01/2019.
  */

import fr.upem.board.Board
import fr.upem.coordinate.Coordinate
import fr.upem.mobility.Orientations.{Orientation, E, N, W, S}
import fr.upem.mobility.Directions.{Direction, G, D}



final case class Mower(coordinate: Coordinate, orientation: Orientation) {}

object Mower {
  def move(mow: Mower, board: Board): Mower = {
    mow.orientation match {
      case N if mow.coordinate.posY + 1 <= board.coordinate.posY && Board.validCoordinate(Coordinate(mow.coordinate.posX, mow.coordinate.posY + 1), board.mowers)
      => Mower(Coordinate(mow.coordinate.posX, mow.coordinate.posY + 1), mow.orientation)

      case E if mow.coordinate.posX + 1 <= board.coordinate.posY && Board.validCoordinate(Coordinate(mow.coordinate.posX + 1, mow.coordinate.posY), board.mowers)
      => Mower(Coordinate(mow.coordinate.posX + 1, mow.coordinate.posY), mow.orientation)

      case W if mow.coordinate.posX - 1 >= 0 && Board.validCoordinate(Coordinate(mow.coordinate.posX - 1, mow.coordinate.posY), board.mowers)
      => Mower(Coordinate(mow.coordinate.posX - 1, mow.coordinate.posY), mow.orientation)

      case S if mow.coordinate.posY - 1 >= 0 && Board.validCoordinate(Coordinate(mow.coordinate.posX, mow.coordinate.posY - 1), board.mowers)
      => Mower(Coordinate(mow.coordinate.posX, mow.coordinate.posY - 1), mow.orientation)

      case _ => Mower(Coordinate(mow.coordinate.posX, mow.coordinate.posY), mow.orientation)
    }
  }

  def newOrientation(mow: Mower, direction: Direction): Mower = {
    direction match {
      case G =>
        mow.orientation match {
          case N => Mower(Coordinate(mow.coordinate.posX, mow.coordinate.posY), W)
          case E => Mower(Coordinate(mow.coordinate.posX, mow.coordinate.posY), N)
          case W => Mower(Coordinate(mow.coordinate.posX, mow.coordinate.posY), S)
          case S => Mower(Coordinate(mow.coordinate.posX, mow.coordinate.posY), E)
        }

      case D =>
        mow.orientation match {
          case N => Mower(Coordinate(mow.coordinate.posX, mow.coordinate.posY), E)
          case E => Mower(Coordinate(mow.coordinate.posX, mow.coordinate.posY), S)
          case W => Mower(Coordinate(mow.coordinate.posX, mow.coordinate.posY), N)
          case S => Mower(Coordinate(mow.coordinate.posX, mow.coordinate.posY), W)
        }

      case _ => Mower(Coordinate(mow.coordinate.posX, mow.coordinate.posY), mow.orientation)

    }
  }

}
