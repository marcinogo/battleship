package pl.wilki.battleship;


import org.testng.annotations.Test;

/**
 * @author Marcin Ogorzalek
 */
@Test
public class BoardTest {
  public void testIfCreatedBoardHaveProperHeight() {
    int height = 15;
    Board board = new Board(height, 10);
    assert board.getHeight() == height : String.format("Board height should be %d", height);
  }

  public void testIfCreatedBoardHaveProperWidth() {
    int width = 15;
    Board board = new Board(10, width);
    assert board.getWidth() == width : String.format("Board width should be %d", width);
  }

  public void testIfCreatedDefaultBoardHaveProperDimensions() {
    int height = 10;
    int width = 10;
    Board board = new Board();
    assert board.getHeight() == height : String.format("Board height should be %d", height);
    assert board.getWidth() == width : String.format("Board width should be %d", width);
  }
}