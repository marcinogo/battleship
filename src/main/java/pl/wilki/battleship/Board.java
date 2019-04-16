package pl.wilki.battleship;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import pl.wilki.battleship.Field.FieldState;

/**
 * @author Marcin Ogorzalek
 */

class Board {
  private int height;
  private int width;
  private List<Field> boardFields;

  Board(int height, int width) {
    this.height = height;
    this.width = width;
    setBoardFieldsToWater();
  }

  Board() {
    this(10, 10);
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

  private void setBoardFieldsToWater() {
    this.boardFields = new ArrayList<>(Arrays.asList(new Field[height*width]));
    Collections.fill(this.boardFields, new Field(FieldState.WATER));
  }
}
