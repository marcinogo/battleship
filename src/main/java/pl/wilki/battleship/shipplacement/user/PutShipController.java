package pl.wilki.battleship.shipplacement.user;

import java.util.ArrayList;
import java.util.List;
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

  @MessageMapping("/putShip")
  @SendTo("/topic/putMyShipMan")
  public PutShipResult shot(PutShipObject putShipObject) throws Exception {
    /*
     * ONLY FOR TEST IMPLEMENTATION. HAVE TO CREATE JAVA CLASS THAT TAKES BOOLEAN VERTICAL/HORIZONTAL, AND ID, AND RETURNS PutShipResult valid Object!!!!
     * in final version we would use class that returns list of fields to mark. PEACE
     * */
    int id = putShipObject.getId();
    boolean shiftPressed = putShipObject.isShiftPressed();
    List<Integer> toReturn = new ArrayList<>();
    if (shiftPressed) {

      for (int i = 0; i < 4; i++) {
        int toAdd = id + i;
        System.out.println(toAdd);
        toReturn.add(toAdd);
      }
    } else {
      for (int i = 0; i < 40; i += 10) {
        int toAdd = id + i;
        toReturn.add(toAdd);
      }
    }

    if (shipPutValidator.isValid(putShipObject)) {
      return new PutShipResult(toReturn, true);
    } else {
      return new PutShipResult(null, false);
    }
  }

}
