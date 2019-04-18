package pl.wilki.battleship.board;

import pl.wilki.battleship.board.Field.FieldState;

/**
 * Responsible for change state of board field to different state: MAST
 * during settings game phase of application.
 *
 * @author Marcin Ogorzalek
 */
class FieldStateChangerSettingPhase implements FieldStateChanger {

  /**
   * Based on parameter return new Field with different state or parameter one.
   *
   * @param field Field with different state if change is needed.
   * @return new Field with state MAST if parameter had state WATER,
   *         otherwise return parameter.
   */
  @Override
  public Field changeFieldState(Field field) {
      return setMastOnWater(field);
  }

  private Field setMastOnWater(Field field) {
    if (field.getFieldState().equals(FieldState.WATER)) {
      return new Field(FieldState.MAST);
    }
    return field;
  }
}
