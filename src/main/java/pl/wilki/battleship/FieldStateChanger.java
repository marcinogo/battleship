package pl.wilki.battleship;

import pl.wilki.battleship.Field.FieldState;

/**
 * @author Marcin Ogorzalek
 */
class FieldStateChanger {

  Field changeFieldState(GameState gameState, Field field) {
    if(gameState.equals(GameState.SETTINGS)) {
      return setMastOnWater(field);
    } else {
      return markMastAsHit(field);
    }
  }

  Field markWaterAsHit(Field field) {
    if(field.getFieldState().equals(FieldState.WATER)) {
      return new Field(FieldState.HIT_WATER);
    }
    return field;
  }

  Field setMastOnWater(Field field) {
    if(field.getFieldState().equals(FieldState.WATER)) {
      return new Field(FieldState.MAST);
    }
    return field;
  }

  Field markMastAsHit(Field field) {
    if(field.getFieldState().equals(FieldState.MAST)) {
    return new Field(FieldState.HIT_MAST);
    }
    return markWaterAsHit(field);
  }
}
