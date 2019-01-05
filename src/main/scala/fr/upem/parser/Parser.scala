package fr.upem.parser

import scala.io.Source
import java.nio.file.{Files, Paths}

import fr.upem.coordinate.Coordinate

/**
  * Created by Hugo on 04/01/2019.
  */
object Parser extends App {
  def readFile(fileName: String): List[String] = {
    return Source.fromFile(fileName).getLines().toList
  }

  def readBoardSize(lines: List[String]): Coordinate = {
    val coordinate = lines(0).split(" ");
    if (coordinate.length != 2){
      println("wrong parameters for the board's size");
      return Coordinate(0, 0);
    }
    val x = coordinate(0).toInt;
    val y = coordinate(1).toInt;
    return Coordinate(x, y)
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
      }
    }
  }
}
