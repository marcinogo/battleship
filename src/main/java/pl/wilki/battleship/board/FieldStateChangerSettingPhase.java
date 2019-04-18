package pl.wilki.battleship.board;

import pl.wilki.battleship.board.Field.FieldState;

/**
 * @author Marcin Ogorzalek
 */
class FieldStateChangerSettingPhase implements FieldStateChanger {

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
