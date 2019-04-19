package pl.wilki.battleship.board;

import pl.wilki.battleship.board.Field.FieldState;

/**
 * Responsible for change state of board field to different state: HIT_MAST and HIT_WATER
 * during game play phase of application.
 *
 * @author Marcin Ogorzalek
 */
class FieldStateChangerGamePhase implements FieldStateChanger {

  /**
   * Based on parameter return new Field with different state or parameter one.
   *
   * @param field Field with different state if change is needed.
   * @return new Field with state HIT_MAST if parameter had state MAST,
   *         if parameter had state WATER return Field with HIT_WATER state,
   *         otherwise return parameter.
   */
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
