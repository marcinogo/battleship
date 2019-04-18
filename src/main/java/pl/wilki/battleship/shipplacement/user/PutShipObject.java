package pl.wilki.battleship.shipplacement.user;

public class PutShipObject {

  private boolean shiftPressed;
  private int id;

  public PutShipObject() {
  }

  public PutShipObject(int id, boolean shiftPressed) {
    this.shiftPressed = shiftPressed;
    this.id = id;
  }

  int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  boolean isShiftPressed() {
    return shiftPressed;
  }

  public void setShiftPressed(boolean shiftPressed) {
    this.shiftPressed = shiftPressed;
  }

}
