package pl.wilki.battleship.board;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import pl.wilki.battleship.GameState;
import pl.wilki.battleship.board.Field.FieldState;

/**
 * @author Marcin Ogorzalek
 */

class Board {
  private final int height;
  private final int width;
  private final List<Field> boardFields;

  Board(int height, int width) {
    this.height = height;
    this.width = width;
    this.boardFields = setBoardFieldsToWater();
  }

  private List<Field> setBoardFieldsToWater() {
    List<Field> boardFields = new ArrayList<>(Arrays.asList(new Field[height * width]));
    Collections.fill(boardFields, new Field(FieldState.WATER));
    return boardFields;
  }

  Board() {
    this(10, 10);
  }

  private Board(Board originalBoard) {
    this.height = originalBoard.height;
    this.width = originalBoard.width;
    this.boardFields = copyBoardFields(originalBoard.boardFields);
  }

  private List<Field> copyBoardFields(List<Field> boardFields) {
    List<Field> copyList = new ArrayList<>();
    for (Field field: boardFields) {
      copyList.add(field.copyField());
    }
    return copyList;
  }

  int getHeight() {
    return height;
  }

  int getWidth() {
    return width;
  }

  List<Field> getFields() {
    return boardFields;
  }

  Board changeFieldState(GameState gameState, int index) {
    Board copy = new Board(this);
    Field oldField = copy.boardFields.get(index);
    Field newField = new FieldStateChanger().changeFieldState(gameState, oldField);
    copy.boardFields.set(index, newField);
    return copy;
  }
}
