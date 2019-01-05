package fr.upem.parser

import scala.io.Source

/**
  * Created by Hugo on 04/01/2019.
  */
object Parser extends App {
  def readFile(fileName: String): Unit = {
    for (line <- Source.fromFile(fileName).getLines){
      print(line);
    }
  }

  override def main(args: Array[String]): Unit = {
    readFile()
  }
}
