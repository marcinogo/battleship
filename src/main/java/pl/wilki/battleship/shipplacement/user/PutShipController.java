package pl.wilki.battleship.shipplacement.user;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

/**
 * @author Kacper Staszek
 */
@Controller
class PutShipController {

  @Autowired
  private ShipPutValidator shipPutValidator;

  /**
   * @param putShipObject contains all information about putting ship try.
   * @return result of trying to put ship on given field. If attempt is valid, than it generates list of fields where ship will be placed.
   */
  @MessageMapping("/putShip")
  @SendTo("/topic/putMyShipMan")
  public PutShipResult shot(PutShipObject putShipObject) {

    Map<Integer,String> toReturn = new HashMap<>();
    if (putShipObject.isShiftPressed()) {
      createShipVertical(putShipObject.getId(), toReturn);
    } else {
      createShipHorizontal(putShipObject.getId(), toReturn);
    }

    if (shipPutValidator.isValid(putShipObject))
      return new PutShipResult(toReturn, true);

    return new PutShipResult(null, false);

  }

  private void createShipHorizontal(int id, Map<Integer,String> toReturn) {
    for (int i = 0; i < 40; i += 10) {
      int toAdd = id + i;
      toReturn.put(toAdd,"#000000");
    }
  }

  private void createShipVertical(int id, Map<Integer,String> toReturn) {
    for (int i = 0; i < 4; i++) {
      int toAdd = id + i;
      toReturn.put(toAdd,"#000000");
    }
  }

}
