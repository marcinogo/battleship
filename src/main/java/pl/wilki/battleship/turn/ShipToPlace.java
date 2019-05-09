package pl.wilki.battleship.turn;

/**
 * @author Jakub Czajka
 */
class ShipToPlace {

  int[] shipSizeToPlace = {4, 3, 3, 2, 2, 2, 1, 1, 1, 1};
  int nextShipToPlace = 0;

  int nextShipSize() {
    return shipSizeToPlace[nextShipToPlace];
  }

  int shipSizeAndIncrement() {
    nextShipToPlace++;
    return shipSizeToPlace[nextShipToPlace - 1];
  }
}
