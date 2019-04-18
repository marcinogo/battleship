package pl.wilki.battleship.shipplacement.random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

/**
 * @author Ola Podorska
 */

@Controller
class RandomShipsController {

  @Autowired
  private ShipGenerator generator;

  @MessageMapping("/ships")
  @SendTo("/topic/randomShipsOnBoard")
  public Ships field() throws Exception {
    return new Ships(generator.generateShips());
  }
}
