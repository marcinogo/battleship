package pl.wilki.battleship.board;

import pl.wilki.battleship.GameState;
import pl.wilki.battleship.board.Field.FieldState;

/**
 * @author Marcin Ogorzalek
 */
class FieldStateChanger {

  Field changeFieldState(GameState gameState, Field field) {
    if (gameState.equals(GameState.SETTINGS)) {
      return setMastOnWater(field);
    } else {
      return markMastAsHit(field);
    }
  }

  private Field markWaterAsHit(Field field) {
    if (field.getFieldState().equals(FieldState.WATER)) {
      return new Field(FieldState.HIT_WATER);
    }
    return field;
  }

  private Field setMastOnWater(Field field) {
    if (field.getFieldState().equals(FieldState.WATER)) {
      return new Field(FieldState.MAST);
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
