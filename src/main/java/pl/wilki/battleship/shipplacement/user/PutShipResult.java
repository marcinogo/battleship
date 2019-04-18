package pl.wilki.battleship.shipplacement.user;

import java.util.List;

/**
 * @author Kacper Staszek
 */
class PutShipResult {

  private List<Integer> fieldsOfShip;
  private boolean valid;

  public PutShipResult() {

  }

  PutShipResult(List<Integer> fieldsOfShip, boolean valid) {
    this.fieldsOfShip = fieldsOfShip;
    this.valid = valid;
  }

  public PutShipResult result(List<Integer> fieldsOfShip, boolean valid) {
    return new PutShipResult(fieldsOfShip, valid);
  }

  public List<Integer> getFieldsOfShip() {
    return fieldsOfShip;
  }

  public void setFieldsOfShip(List<Integer> fieldsOfShip) {
    this.fieldsOfShip = fieldsOfShip;
  }

  public boolean isValid() {
    return valid;
  }

  public void setValid(boolean valid) {
    this.valid = valid;
  }
}
