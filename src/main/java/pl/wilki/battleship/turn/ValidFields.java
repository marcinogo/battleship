package pl.wilki.battleship.turn;

import java.util.List;

/**
 * @author Jakub Czajka
 */
class ValidFields {

  List<Integer> validFieldsToPlace;

  public ValidFields(List<Integer> validFieldsToPlace) {
    this.validFieldsToPlace = validFieldsToPlace;
  }

  boolean areValidToPlace(List<Integer> fieldsToCheck) {
    return validFieldsToPlace.contains(fieldsToCheck);
  }

}
