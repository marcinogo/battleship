package pl.wilki.battleship.shipplacement.user;

import java.util.List;
import java.util.Map;

/**
 * For Spring object. Holds information about PutShipResult, such as if it is valid, and list of fields to mark.
 * @author Kacper Staszek
 */
class PutShipResult {

  private Map<Integer,String> fieldsOfShip;
  private boolean valid;

  public PutShipResult() {

  }

  PutShipResult(Map<Integer,String> fieldsOfShip, boolean valid) {
    this.fieldsOfShip = fieldsOfShip;
    this.valid = valid;
  }

  PutShipResult result(Map<Integer,String> fieldsOfShip, boolean valid) {
    return new PutShipResult(fieldsOfShip, valid);
  }

  public Map<Integer,String> getFieldsOfShip() {
    return fieldsOfShip;
  }

  public void setFieldsOfShip(Map<Integer,String> fieldsOfShip) {
    this.fieldsOfShip = fieldsOfShip;
  }

  public boolean isValid() {
    return valid;
  }

  public void setValid(boolean valid) {
    this.valid = valid;
  }
}
