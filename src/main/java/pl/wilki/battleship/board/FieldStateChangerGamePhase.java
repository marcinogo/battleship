package pl.wilki.battleship.board;

import pl.wilki.battleship.board.Field.FieldState;

/**
 * @author Marcin Ogorzalek
 */
class FieldStateChangerGamePhase implements FieldStateChanger {

  @Override
  public Field changeFieldState(Field field) {
      return markMastAsHit(field);
  }

  private Field markWaterAsHit(Field field) {
    if (field.getFieldState().equals(FieldState.WATER)) {
      return new Field(FieldState.HIT_WATER);
    }
    return field;
  }

  private Field markMastAsHit(Field field) {
    if (field.getFieldState().equals(FieldState.MAST)) {
      return new Field(FieldState.HIT_MAST);
    }
    return markWaterAsHit(field);
  }
}
