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
    return new Field(FieldState.MAST);
  }

  Field markMastAsHit(Field field) {
    return new Field(FieldState.HIT_MAST);
  }
}
