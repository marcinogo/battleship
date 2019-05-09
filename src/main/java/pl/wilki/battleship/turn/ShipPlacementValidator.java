package pl.wilki.battleship.turn;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author Jakub Czajka
 */
class ShipPlacementValidator implements Validator {

  private ShipToPlace shipToPlace;
  private ValidFields validFields;


  ShipPlacementValidator(ShipToPlace shipToPlace, ValidFields validFields) {
    this.shipToPlace = shipToPlace;
    this.validFields = validFields;
  }

  /**
   * @param verticalPlacement if true ship would be place vertically if false horizontally
   * @return O1 object containing String message and list integer that represents ship placement
   */
  @Override
  public O1 validate(int fieldNumber, boolean verticalPlacement) {
    if (isFieldCorrect(fieldNumber, verticalPlacement, shipToPlace.nextShipSize())
        && validFields
        .areValidToPlace(createShip(fieldNumber, verticalPlacement, shipToPlace.nextShipSize()))) {
      return new O1(createShip(fieldNumber, verticalPlacement, shipToPlace.shipSizeAndIncrement()),
          "");
    }
    return new O1(null, "Invalid input");
  }

  List<Integer> createShip(int fieldNumber, boolean verticalPlacement, int shipSize) {
    if (verticalPlacement) {
      return IntStream.range(0, shipSize)
          .map(i -> fieldNumber - 10 * i)
          .boxed()
          .collect(Collectors.toList());
    } else {
      return IntStream.range(0, shipSize)
          .map(i -> fieldNumber + i)
          .boxed()
          .collect(Collectors.toList());

    }
  }

  /**
   *
   */
  boolean isFieldCorrect(int fieldNumber, boolean verticalPlacement, int shipSize) {
    if (verticalPlacement) {
      return fieldNumber / 10 + 1 >= shipSize;
    } else {
      return fieldNumber / 10 == (fieldNumber + shipSize - 1) / 10;
    }
  }
}
