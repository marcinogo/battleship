package pl.wilki.battleship;


import java.util.List;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pl.wilki.battleship.Field.FieldState;

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
    assert boardFields.size() == height*width : String.format("Board should have list of"
        + " fields with size %d", height*width);
  }

  public void testIfCreatedDefaultBoardHaveFieldsListWithProperSize() {
    Board board = new Board();
    List<Field> boardFields = board.getFields();
    assert boardFields.size() == 10*10 : String.format("Board should have list of"
        + " fields with size %d", 10*10);
  }

  @DataProvider
  public static Object[][] newDefaultBoardFieldsCheck(){
      return new Object[][] {
          {0, FieldState.WATER},
          {99, FieldState.WATER},
          {1, FieldState.WATER},
          {98, FieldState.WATER},
          {45, FieldState.WATER},
          {55, FieldState.WATER},
          {50, FieldState.WATER},
          {51, FieldState.WATER},
          {49, FieldState.WATER},
          {10, FieldState.WATER},
          {90, FieldState.WATER},
      };
  }

  @Test(dataProvider = "newDefaultBoardFieldsCheck")
  public void testIfNewDefaultBoardFieldsAreSetToWater(int index, FieldState fieldState) {
    Board board = new Board();
    Field fieldOnIndex = board.getFields().get(index);
    assert fieldOnIndex.getFieldState().equals(fieldState) : "All fields"
        + " should have state WATER";
  }
}