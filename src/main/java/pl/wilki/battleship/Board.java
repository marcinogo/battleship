package pl.wilki.battleship;

/**
 * @author Marcin Ogorzalek
 */

class Board {
  private int height;
  private int width;

  Board(int height, int width) {
    this.height = height;
    this.width = width;
  }

  int getHeight() {
    return height;
  }

  int getWidth() {
    return width;
  }
}
