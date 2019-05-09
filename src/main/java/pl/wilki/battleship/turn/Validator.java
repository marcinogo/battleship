package pl.wilki.battleship.turn;

/**
 * @author Jakub Czajka
 */
public interface Validator {

  O1 validate(int fieldNumber, boolean keyPressed);
}
