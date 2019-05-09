package pl.wilki.battleship.turn;

/**
 * @author Marcin Ogorzalek
 */
public enum Field {
  WATER("#FEFDFD"),
  WATER_SHOTED("#10DDE8"),
  SHIP("#111111"),
  SHIP_SHOTED("#F50D18");

  private String color;

  Field(String color) {
    this.color = color;
  }

  @Override
  public String toString() {
    return color;
  }
}
