package pl.wilki.battleship.board;

import java.util.Objects;

/**
 * @author Marcin Ogorzalek
 */
class Field {
  private final FieldState fieldState;

  Field(FieldState fieldState) {
    this.fieldState = fieldState;
  }

  private Field(Field originalField) {
    this(originalField.fieldState);
  }

  Field copyField() {
    return new Field(this);
  }

  @Override
  public String toString() {
    return fieldState.toString();
  }

  FieldState getFieldState() {
    return fieldState;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    Field field = (Field) obj;
    return fieldState == field.fieldState;
  }

  @Override
  public int hashCode() {
    return Objects.hash(fieldState);
  }

  /**
   * Represent all possible states of Board fields during game.
   */
  enum FieldState {
    WATER("[ ]"),
    HIT_WATER("[O]"),
    MAST("[*]"),
    HIT_MAST("[X]");

    private final String representation;

    FieldState(String representation) {
      this.representation = representation;
    }

    @Override
    public String toString() {
      return representation;
    }
  }
}
