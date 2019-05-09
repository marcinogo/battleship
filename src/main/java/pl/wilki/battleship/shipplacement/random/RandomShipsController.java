package pl.wilki.battleship.shipplacement.random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;

/**
 * @author Ola Podorska
 */

@Controller
class RandomShipsController {

  @Autowired
  private ShipGenerator generator;

  /**
   * @return Ships object, witch have list of fields to mark on board.
   */
  @MessageMapping("/ships")
  @SendToUser("/queue/randomShipsOnBoard")
  public Ships field() {
    return new Ships(generator.generateShips());
  }
}
