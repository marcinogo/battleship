package pl.wilki.battleship.turn;

import java.util.List;

/**
 * @author Jakub Czajka
 */
class O1 {

  List<Integer> fieldsIndexes;
  String message;

  public O1(List<Integer> fieldsIndexes, String message) {
    this.fieldsIndexes = fieldsIndexes;
    this.message = message;
  }

  public List<Integer> getFieldsIndexes() {
    return fieldsIndexes;
  }

  public String getMessage() {
    return message;
  }
}
