package pl.wilki.battleship.shipplacement.user;

class PutShipObject {

  private boolean shiftPressed;
  private int id;

  PutShipObject() {
  }

  PutShipObject(int id, boolean shiftPressed) {
    this.shiftPressed = shiftPressed;
    this.id = id;
  }

  int getId() {
    return id;
  }

  void setId(int id) {
    this.id = id;
  }

  boolean isShiftPressed() {
    return shiftPressed;
  }

  void setShiftPressed(boolean shiftPressed) {
    this.shiftPressed = shiftPressed;
  }

}
