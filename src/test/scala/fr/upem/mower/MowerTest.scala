package fr.upem.mower
import fr.upem.board.Board
import fr.upem.coordinate.Coordinate
import fr.upem.mobility.Orientations.{E, N, S, W}
import fr.upem.mobility.Directions.{D, G}
import org.scalatest.{FlatSpec, Matchers}

class MowerTest extends FlatSpec with Matchers{
  "Create a new Mower with coordinate (5,5) and orientation N" should "has coordinate x = 5, y = 5 and orientation N" in {
    val mower = Mower(Coordinate(5,5), N);
    assert(mower.coordinate.posX == 5);
    assert(mower.coordinate.posY == 5);
    assert(mower.orientation == N);
  }

  "Create a new Mower with coordinate (5,5) and orientation N which moves" should "be at (5,6) and N" in {
    val board = Board(Coordinate(10,10), List.empty[Mower])
    val mower = Mower(Coordinate(5,5), N);
    val mowerFinal = Mower.move(mower, board)
    assert(mowerFinal.coordinate.posX == 5);
    assert(mowerFinal.coordinate.posY == 6);
    assert(mowerFinal.orientation == N);
  }

  "Create a new Mower with coordinate (5,5) and orientation S which moves" should "be at (5,4) and S" in {
    val board = Board(Coordinate(10,10), List.empty[Mower])
    val mower = Mower(Coordinate(5,5), S);
    val mowerFinal = Mower.move(mower, board)
    assert(mowerFinal.coordinate.posX == 5);
    assert(mowerFinal.coordinate.posY == 4);
    assert(mowerFinal.orientation == S);
  }

  "Create a new Mower with coordinate (5,5) and orientation E which moves" should "be at (6,5) and E" in {
    val board = Board(Coordinate(10,10), List.empty[Mower])
    val mower = Mower(Coordinate(5,5), E);
    val mowerFinal = Mower.move(mower, board)
    assert(mowerFinal.coordinate.posX == 6);
    assert(mowerFinal.coordinate.posY == 5);
    assert(mowerFinal.orientation == E);
  }

  "Create a new Mower with coordinate (5,5) and orientation W which moves" should "be at (4,5) and S" in {
    val board = Board(Coordinate(10,10), List.empty[Mower])
    val mower = Mower(Coordinate(5,5), W);
    val mowerFinal = Mower.move(mower, board)
    assert(mowerFinal.coordinate.posX == 4);
    assert(mowerFinal.coordinate.posY == 5);
    assert(mowerFinal.orientation == W);
  }

  "Create a new Mower with coordinate (5,5) and orientation N which rotates of +90°" should "be at (5,5) and E" in {
    val board = Board(Coordinate(10,10), List.empty[Mower])
    val mower = Mower(Coordinate(5,5), N);
    val mowerFinal = Mower.newOrientation(mower, D)
    assert(mowerFinal.coordinate.posX == 5);
    assert(mowerFinal.coordinate.posY == 5);
    assert(mowerFinal.orientation == E);
  }

  "Create a new Mower with coordinate (5,5) and orientation N which rotates of -90°" should "be at (5,5) and W" in {
    val board = Board(Coordinate(10,10), List.empty[Mower])
    val mower = Mower(Coordinate(5,5), N);
    val mowerFinal = Mower.newOrientation(mower, G)
    assert(mowerFinal.coordinate.posX == 5);
    assert(mowerFinal.coordinate.posY == 5);
    assert(mowerFinal.orientation == W);
  }

  "Create a new Mower with coordinate (5,5) and orientation S which rotates of +90°" should "be at (5,5) and W" in {
    val board = Board(Coordinate(10,10), List.empty[Mower])
    val mower = Mower(Coordinate(5,5), S);
    val mowerFinal = Mower.newOrientation(mower, D)
    assert(mowerFinal.coordinate.posX == 5);
    assert(mowerFinal.coordinate.posY == 5);
    assert(mowerFinal.orientation == W);
  }

  "Create a new Mower with coordinate (5,5) and orientation S which rotates of -90°" should "be at (5,5) and E" in {
    val board = Board(Coordinate(10,10), List.empty[Mower])
    val mower = Mower(Coordinate(5,5), S);
    val mowerFinal = Mower.newOrientation(mower, G)
    assert(mowerFinal.coordinate.posX == 5);
    assert(mowerFinal.coordinate.posY == 5);
    assert(mowerFinal.orientation == E);
  }

  "Create a new Mower with coordinate (5,5) and orientation E which rotates of +90°" should "be at (5,5) and S" in {
    val board = Board(Coordinate(10,10), List.empty[Mower])
    val mower = Mower(Coordinate(5,5), S);
    val mowerFinal = Mower.newOrientation(mower, D)
    assert(mowerFinal.coordinate.posX == 5);
    assert(mowerFinal.coordinate.posY == 5);
    assert(mowerFinal.orientation == W);
  }

  "Create a new Mower with coordinate (5,5) and orientation E which rotates of -90°" should "be at (5,5) and N" in {
    val board = Board(Coordinate(10,10), List.empty[Mower])
    val mower = Mower(Coordinate(5,5), S);
    val mowerFinal = Mower.newOrientation(mower, G)
    assert(mowerFinal.coordinate.posX == 5);
    assert(mowerFinal.coordinate.posY == 5);
    assert(mowerFinal.orientation == E);
  }

  "Create a new Mower with coordinate (5,5) and orientation W which rotates of +90°" should "be at (5,5) and N" in {
    val board = Board(Coordinate(10,10), List.empty[Mower])
    val mower = Mower(Coordinate(5,5), W);
    val mowerFinal = Mower.newOrientation(mower, D)
    assert(mowerFinal.coordinate.posX == 5);
    assert(mowerFinal.coordinate.posY == 5);
    assert(mowerFinal.orientation == N);
  }

  "Create a new Mower with coordinate (5,5) and orientation W which rotates of -90°" should "be at (5,5) and S" in {
    val board = Board(Coordinate(10,10), List.empty[Mower])
    val mower = Mower(Coordinate(5,5), W);
    val mowerFinal = Mower.newOrientation(mower, G)
    assert(mowerFinal.coordinate.posX == 5);
    assert(mowerFinal.coordinate.posY == 5);
    assert(mowerFinal.orientation == S);
  }
}
