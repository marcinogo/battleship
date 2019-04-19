package pl.wilki.battleship.shipplacement.user;

import org.springframework.stereotype.Component;

/**
 * @author Kacper Staszek
 */
@Component
class ShipPutValidator {

  boolean isValid(PutShipObject putShipObject) {
    return true;
  }
}
