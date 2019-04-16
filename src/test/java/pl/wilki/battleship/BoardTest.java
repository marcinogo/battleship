package pl.wilki.battleship;


import java.util.List;
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

  public void testIfCreatedBoardHaveFieldsListWithProperSize() {
    int height = 15;
    int width = 20;
    Board board = new Board(height, width);
    List<Field> boardFields = board.getFields();
    System.out.println(boardFields.size());
    assert boardFields.size() == height*width : String.format("Board should have list of"
        + " fields with size %d", height*width);
  }

  public void testIfCreatedDefaultBoardHaveFieldsListWithProperSize() {
    Board board = new Board();
    List<Field> boardFields = board.getFields();
    System.out.println(boardFields.size());
    assert boardFields.size() == 10*10 : String.format("Board should have list of"
        + " fields with size %d", 10*10);
  }
}