package pl.wilki.battleship.board;


import java.util.List;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pl.wilki.battleship.board.Field.FieldState;

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

  @DataProvider
  public static Object[][] setFieldCheck(){
    return new Object[][] {
        {new FieldStateChangerGamePhase(), 0, FieldState.HIT_WATER},
        {new FieldStateChangerGamePhase(), 1, FieldState.HIT_WATER},
        {new FieldStateChangerGamePhase(), 99, FieldState.HIT_WATER},
        {new FieldStateChangerGamePhase(), 98, FieldState.HIT_WATER},
        {new FieldStateChangerGamePhase(), 45, FieldState.HIT_WATER},
        {new FieldStateChangerGamePhase(), 55, FieldState.HIT_WATER},
        {new FieldStateChangerGamePhase(), 50, FieldState.HIT_WATER},
        {new FieldStateChangerGamePhase(), 51, FieldState.HIT_WATER},
        {new FieldStateChangerGamePhase(), 49, FieldState.HIT_WATER},
        {new FieldStateChangerGamePhase(), 10, FieldState.HIT_WATER},
        {new FieldStateChangerGamePhase(), 90, FieldState.HIT_WATER},
        {new FieldStateChangerSettingPhase(), 0, FieldState.MAST},
        {new FieldStateChangerSettingPhase(), 1, FieldState.MAST},
        {new FieldStateChangerSettingPhase(), 99, FieldState.MAST},
        {new FieldStateChangerSettingPhase(), 98, FieldState.MAST},
        {new FieldStateChangerSettingPhase(), 45, FieldState.MAST},
        {new FieldStateChangerSettingPhase(), 55, FieldState.MAST},
        {new FieldStateChangerSettingPhase(), 50, FieldState.MAST},
        {new FieldStateChangerSettingPhase(), 51, FieldState.MAST},
        {new FieldStateChangerSettingPhase(), 49, FieldState.MAST},
        {new FieldStateChangerSettingPhase(), 10, FieldState.MAST},
        {new FieldStateChangerSettingPhase(), 90, FieldState.MAST},
    };
  }

  @Test(dataProvider = "setFieldCheck")
  public void testIfBoardFieldOnIndexIsSet(FieldStateChanger fieldStateChanger,
      int index, FieldState expectedFieldState) {
    Board board = new Board();
    Board resultBoard = board.changeFieldState(fieldStateChanger, index);
    Field expected = new Field(expectedFieldState);
    assert expected.equals(resultBoard.getFields().get(index)) : "Fields should be equals";
  }

  @DataProvider
  public static Object[][] setMastFieldCheck(){
    return new Object[][] {
        {new FieldStateChangerGamePhase(), 0, FieldState.HIT_MAST},
        {new FieldStateChangerGamePhase(), 1, FieldState.HIT_MAST},
        {new FieldStateChangerGamePhase(), 99, FieldState.HIT_MAST},
        {new FieldStateChangerGamePhase(), 98, FieldState.HIT_MAST},
        {new FieldStateChangerGamePhase(), 45, FieldState.HIT_MAST},
        {new FieldStateChangerGamePhase(), 55, FieldState.HIT_MAST},
        {new FieldStateChangerGamePhase(), 50, FieldState.HIT_MAST},
        {new FieldStateChangerGamePhase(), 51, FieldState.HIT_MAST},
        {new FieldStateChangerGamePhase(), 49, FieldState.HIT_MAST},
        {new FieldStateChangerGamePhase(), 10, FieldState.HIT_MAST},
        {new FieldStateChangerGamePhase(), 90, FieldState.HIT_MAST},
    };
  }

  @Test(dataProvider = "setMastFieldCheck")
  public void testIfBoardFieldOnIndexIsSetIfHadMastState(FieldStateChanger fieldStateChanger,
      int index, FieldState expectedFieldState) {
    Board board = new Board();
    board.getFields().set(index, new Field(FieldState.MAST));
    Board resultBoard = board.changeFieldState(fieldStateChanger, index);
    Field expected = new Field(expectedFieldState);
    assert expected.equals(resultBoard.getFields().get(index)) : "Fields should be equals";
  }
}