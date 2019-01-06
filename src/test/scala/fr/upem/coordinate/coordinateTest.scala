package fr.upem.coordinate
import org.scalatest.{FlatSpec, Matchers}

class coordinateTest extends FlatSpec with Matchers{
  "Create a new Coordinate with (5,5)" should "has coordinate x = 5, y = 5" in {
    val coordinate = Coordinate(5,5)
    assert(coordinate.posX == 5);
    assert(coordinate.posY == 5);
  }
}
