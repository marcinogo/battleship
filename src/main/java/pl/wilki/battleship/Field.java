package pl.wilki.battleship;

import java.util.Objects;

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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Field field = (Field) o;
    return fieldState == field.fieldState;
  }

  @Override
  public int hashCode() {
    return Objects.hash(fieldState);
  }

  enum FieldState {
    WATER("[ ]"),
    HIT_WATER("[O]"),
    MAST("[*]"),
    HIT_MAST("[X]");

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
