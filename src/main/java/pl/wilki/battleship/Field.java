package pl.wilki.battleship;

/**
 * @author Marcin Ogorzalek
 */
class Field {
  private FieldState fieldState;

  Field(FieldState fieldState) {
    this.fieldState = fieldState;
  }

  @Override
  public String toString() {
    return fieldState.toString();
  }

  FieldState getFieldState() {
    return fieldState;
  }

  enum FieldState {
    WATER("[ ]");

    private String representation;

    FieldState(String representation) {
      this.representation = representation;
    }

    @Override
    public String toString() {
      return representation;
    }
  }
}
