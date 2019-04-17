package pl.wilki.battleship.board;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pl.wilki.battleship.GameState;
import pl.wilki.battleship.board.Field.FieldState;

/**
 * @author Marcin Ogorzalek
 */

@Test
public class FieldStateChangerTest {

  @DataProvider
  public static Object[][] checkChangeFieldState(){
      return new Object[][] {
          {GameState.SETTINGS, FieldState.WATER, FieldState.MAST},
          {GameState.SETTINGS, FieldState.MAST, FieldState.MAST},
          {GameState.GAME, FieldState.MAST, FieldState.HIT_MAST},
          {GameState.GAME, FieldState.WATER, FieldState.HIT_WATER},
          {GameState.GAME, FieldState.HIT_WATER, FieldState.HIT_WATER},
          {GameState.GAME, FieldState.HIT_MAST, FieldState.HIT_MAST},
      };
  }

  @Test(dataProvider = "checkChangeFieldState")
  public void testIfChangeFieldStateReturnFieldWithProperState(GameState gameState,
      FieldState initialState, FieldState expectedState) {
    Field initial = new Field(initialState);
    Field expected = new Field(expectedState);
    Field result = new FieldStateChanger().changeFieldState(gameState, initial);
    assert expected.equals(result) : String.format("Field should have %s state",
        expected.getFieldState().name());
  }
}