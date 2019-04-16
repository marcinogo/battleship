package pl.wilki.battleship;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
    this.boardFields = new ArrayList<>(Arrays.asList(new Field[height*width]));
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
}
