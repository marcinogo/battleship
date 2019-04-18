package pl.wilki.battleship.shipplacement.random;

import static org.testng.Assert.assertNotEquals;

import java.util.List;
import org.testng.annotations.Test;

/**
 * @author Kacper Staszek
 */
public class ShipGeneratorTest {

  @Test
  void checkRandomShips() {
    ShipGenerator shipGenerator = new ShipGenerator();

    for (int i = 0; i < 1000; i++) {
      List<Integer> currentList = shipGenerator.generateShips();
      List<Integer> lastList = currentList;
      currentList = shipGenerator.generateShips();
      assertNotEquals(currentList, lastList);
    }
  }

}