package pl.wilki.battleship.turn;

/**
 * @author Marcin Ogorzalek
 */
public enum Field {
  WATER("#FEFDFD"),
  WATER_SHOOTED("#10DDE8"),
  SHIP("#111111"),
  SHIP_SHOOTED("#F50D18");

  private String color;

  Field(String color) {
    this.color = color;
  }

  @Override
  public String toString() {
    return color;
  }
}
