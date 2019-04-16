package pl.wilki.battleship;

import pl.wilki.battleship.Field.FieldState;

/**
 * @author Marcin Ogorzalek
 */
class FieldStateChanger {

  Field markWaterAsHit(Field field) {
    return new Field(FieldState.HIT_WATER);
  }

  Field setMastOnWater(Field field) {
    return new Field(FieldState.MAST);
  }

  Field markMastAsHit(Field field) {
    return new Field(FieldState.HIT_MAST);
  }
}
