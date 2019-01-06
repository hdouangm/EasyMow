package fr.upem.board
import fr.upem.coordinate.Coordinate
import fr.upem.mower.Mower
import org.scalatest.{FlatSpec, Matchers}

class BoardTest extends FlatSpec with Matchers{
  "Create a new Board with coordinate (5,5) and empty List" should "has coordinate x = 5, y = 5" in {
    val board = Board(Coordinate(5,5), List.empty[Mower])
    assert(board.coordinate.posX == 5);
    assert(board.coordinate.posY == 5);
  }
}
