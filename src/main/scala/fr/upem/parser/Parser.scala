package fr.upem.parser

import scala.io.Source
import java.nio.file.{Files, Paths}

import fr.upem.board.Board
import fr.upem.coordinate.Coordinate
import fr.upem.mower.Mower
import fr.upem.mobility.Orientations
import fr.upem.mobility.Directions

/**
  * Created by Hugo on 04/01/2019.
  */
object Parser extends App {
  def readFile(fileName: String): List[String] = {
    return Source.fromFile(fileName).getLines().toList
  }

  def readBoardSize(lines: List[String]): Coordinate = {
    val intRegex = "^(\\d+) (\\d+)$".r()
    lines(0) match {
      case intRegex(x, y) => Coordinate(x.toInt, y.toInt)
      case _ => Coordinate(0,0)
    }
  }

  def readMower(line: String, board: Board): Option[Mower] ={
    val newMowerRegex = "^(\\d+) (\\d+) (N|S|E|W)$".r()
    line match {
      case newMowerRegex(x, y, dir) => return Option(Mower(Coordinate(x.toInt,y.toInt), Orientations.toOrientation(dir).get));
      case _ => return Option.empty
    }
  }



  def moveMower(mower: Mower, line: String, board: Board): Mower ={
    if (line.length == 0){
      return mower;
    }
    val char = line(0);
    if (char == 'D' || char == 'G'){
      val command = Directions.toDirection(char.toString).get;
      return moveMower(Mower.newOrientation(mower, command), line.drop(1), board);
    }
    if (char == 'A'){
      return moveMower(Mower.move(mower, board), line.drop(1), board);
    }
    return moveMower(mower, line.drop(1), board);
  }

  def moveMowers(board: Board, commands: List[String]): Board ={
    if (commands.length == 0){
      return board
    }
    val mower = readMower(commands(0), board);
    val mowerFinal = moveMower(mower.get, commands(1), board);
    return moveMowers(Board(board.coordinate, board.mowers :+ mowerFinal), commands.drop(2));
  }



  override def main(args: Array[String]): Unit = {
    if (args.length < 1){
      println("Please, specify the file's name you want to use !");
    }
    else {
      val path = "Files/" + args(0);
      if (!Files.exists(Paths.get(path))){
        println("The file you specified does not exist");
      }
      else {
        val lines = readFile(path);
        val boardCoordinate = readBoardSize(lines);
        if (boardCoordinate.posX == 0 && boardCoordinate.posY == 0){
          println("The board's coordinates are wrong !")
        }
        else {
          val board = Board(boardCoordinate, List.empty[Mower]);
          val commands = lines.drop(1);
          val boardFinal = moveMowers(board, commands);
          for (mow <- boardFinal.mowers){
            println(mow.coordinate.posX + " " + mow.coordinate.posY);
          }
        }
      }
    }
  }
}
