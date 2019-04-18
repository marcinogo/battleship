package pl.wilki.battleship.shipplacement.random;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import org.springframework.stereotype.Component;

/**
 * @author Ola Podorska
 */

@Component
class ShipGenerator {

  private List<List<Integer>> listOfRandomPlacements = new LinkedList<>();
  private Random random = new Random();
  private int lastRandomNumber = 5;
  private List<Integer> randomPlacementOne = new ArrayList<>();
  private List<Integer> randomPlacementTwo = new ArrayList<>();
  private List<Integer> randomPlacementThree = new ArrayList<>();
  private List<Integer> randomPlacementFour = new ArrayList<>();

  List<Integer> generateShips() {
    fillRandomPlacementOne();
    fillRandomPlacementTwo();
    fillRandomPlacementThree();
    fillRandomPlacementFour();
    int randomInt = 0;
    while (randomInt == lastRandomNumber) {
      randomInt = random.nextInt(4);
    }
    lastRandomNumber = randomInt;
    return listOfRandomPlacements.get(randomInt);
  }

  private void fillRandomPlacementOne() {
    randomPlacementOne.addAll(
        Arrays.asList(1, 2, 3, 4, 23, 24, 25, 20, 30, 40, 56, 57, 70, 80, 98, 99, 43, 38, 74, 76));
    listOfRandomPlacements.add(randomPlacementOne);
  }

  private void fillRandomPlacementTwo() {
    randomPlacementTwo.addAll(
        Arrays.asList(42, 52, 62, 72, 34, 35, 36, 58, 68, 78, 0, 1, 3, 4, 7, 8, 29, 90, 93, 70));
    listOfRandomPlacements.add(randomPlacementTwo);
  }

  private void fillRandomPlacementThree() {
    randomPlacementThree.addAll(Arrays
        .asList(99, 89, 79, 69, 0, 1, 2, 9, 27, 28, 29, 65, 66, 70, 80, 20, 30, 33, 63, 59, 84));
    listOfRandomPlacements.add(randomPlacementThree);

  }

  private void fillRandomPlacementFour() {
    randomPlacementFour.addAll(
        Arrays.asList(35, 45, 65, 91, 92, 93, 86, 87, 88, 0, 10, 31, 41, 29, 39, 9, 4, 55, 67, 69));
    listOfRandomPlacements.add(randomPlacementFour);

  }
}
