package pl.wilki.battleship;

/**
 * @author Marcin Ogorzalek
 */
class Field {
  private FieldState fieldState;

  Field(FieldState fieldState) {
    this.fieldState = fieldState;
  }

  FieldState getFieldState() {
    return fieldState;
  }

  enum FieldState {
    WATER
  }
}
