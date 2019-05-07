package pl.wilki.battleship.turn;

/**
 * @author Marcin Ogorzalek
 */
public enum Field {
  WATER("WHITE"),
  WATER_SHOT("BLUE"),
  SHIP("RED"),
  SHIP_SHOT("BLACK");

  private String color;

  Field(String color) {
    this.color = color;
  }

  @Override
  public String toString() {
    return color;
  }
}
