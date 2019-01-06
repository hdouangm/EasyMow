package fr.upem.parser
import fr.upem.board.Board
import fr.upem.mobility.Orientations.{E, N}
import fr.upem.mower.Mower
import org.scalatest.{FlatSpec, Matchers}

class ParserTest extends FlatSpec with Matchers{
  "read a file named fileTestDontRemove" should "have 5 5 in first line and AADAADADDA in the last one" in {
    val lines = Parser.readFile("Files/fileTestDontRemove")
    assert(lines.head.equals("5 5"));
    assert(lines(4).equals("AADAADADDA"));
  }

  "extract the board size from a text file" should "have a size of 5 5" in {
    val lines = Parser.readFile("Files/fileTestDontRemove")
    val boardCoordinate = Parser.readBoardSize(lines)
    assert(boardCoordinate.posX == 5);
    assert(boardCoordinate.posY == 5);
  }

  "extract a mower from a text file" should "have a position of 1 2 and the N orientation" in {
    val lines = Parser.readFile("Files/fileTestDontRemove")
    val boardCoordinate = Parser.readBoardSize(lines)
    val board = Board(boardCoordinate, List.empty[Mower])
    val mower = Parser.readMower(lines(1), board).get
    assert(mower.coordinate.posX == 1);
    assert(mower.coordinate.posY == 2);
    assert(mower.orientation == N);
  }

  "move mower from 1 2 N to his final position with GAGAGAGAA" should "have a position of 1 3 and the N orientation" in {
    val lines = Parser.readFile("Files/fileTestDontRemove")
    val boardCoordinate = Parser.readBoardSize(lines)
    val board = Board(boardCoordinate, List.empty[Mower])
    val mower = Parser.readMower(lines(1), board).get
    val finalMower = Parser.moveMower(mower, lines(2), board)
    assert(finalMower.coordinate.posX == 1);
    assert(finalMower.coordinate.posY == 3);
    assert(finalMower.orientation == N);
  }

  "extract from a text file all mowers with finals positions" should "have 2 mowers with 1 3 N and 5 1 E" in {
    val lines = Parser.readFile("Files/fileTestDontRemove")
    val boardCoordinate = Parser.readBoardSize(lines)
    val board = Board(boardCoordinate, List.empty[Mower])
    val finalBoard = Parser.moveMowers(board, lines.drop(1))
    assert(finalBoard.mowers.length == 2);
    assert(finalBoard.mowers(0).coordinate.posX == 1);
    assert(finalBoard.mowers(0).coordinate.posY == 3);
    assert(finalBoard.mowers(0).orientation == N);
    assert(finalBoard.mowers(1).coordinate.posX == 5);
    assert(finalBoard.mowers(1).coordinate.posY == 1);
    assert(finalBoard.mowers(1).orientation == E);
  }
}
