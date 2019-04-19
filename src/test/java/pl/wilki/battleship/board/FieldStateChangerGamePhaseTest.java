package pl.wilki.battleship.board;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pl.wilki.battleship.board.Field.FieldState;

/**
 * @author Marcin Ogorzalek
 */
@Test
public class FieldStateChangerGamePhaseTest {


  @DataProvider
  public static Object[][] provideInitialAndExpectedFieldState() {
    return new Object[][]{
        {FieldState.MAST, FieldState.HIT_MAST},
        {FieldState.WATER, FieldState.HIT_WATER},
        {FieldState.HIT_WATER, FieldState.HIT_WATER},
        {FieldState.HIT_MAST, FieldState.HIT_MAST},
    };
  }

  @Test(dataProvider = "provideInitialAndExpectedFieldState")
  public void testIfChangeFieldStateReturnFieldWithProperState(FieldState initialState,
      FieldState expectedState) {
    FieldStateChanger fieldStateChanger = new FieldStateChangerGamePhase();
    Field initial = new Field(initialState);
    Field expected = new Field(expectedState);
    Field result = fieldStateChanger.changeFieldState(initial);
    assert expected.equals(result) : String.format("Field should have %s state",
        expected.getFieldState().name());
  }
}