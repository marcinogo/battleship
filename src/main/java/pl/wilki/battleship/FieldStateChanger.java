package pl.wilki.battleship;

import pl.wilki.battleship.Field.FieldState;

/**
 * @author Marcin Ogorzalek
 */
class FieldStateChanger {

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
    return field;
  }
}
