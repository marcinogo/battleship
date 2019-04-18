package pl.wilki.battleship.board;

/**
 * Responsible for change state of board field to different state
 * depending on implementation.
 *
 * @author Marcin Ogorzalek
 */
interface FieldStateChanger {

  /**
   * Return new Field object with different state to parameter if change is needed.
   * Otherwise return Field from parameter
   *
   * @param field Field state that can be change if it is needed.
   * @return new Field with different state or Field form parameter
   */
  Field changeFieldState(Field field);
}
