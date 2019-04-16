package pl.wilki.battleship;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pl.wilki.battleship.Field.FieldState;

/**
 * @author Marcin Ogorzalek
 */

@Test
public class FieldStateChangerTest {

  public void testIfMarkWaterAsHitReturnFieldWithProperState() {
    FieldState fieldState = FieldState.WATER;
    Field field = new Field(fieldState);
    Field expected = new Field(FieldState.HIT_WATER);
    Field result = new FieldStateChanger().markWaterAsHit(field);
    assert expected.equals(result) : "Returned Field should have state HIT_WATER";
  }

  public void testIfMarkWaterAsHitReturnFieldFromParameterIfItWasNotWater1() {
    FieldState fieldState = FieldState.MAST;
    Field field = new Field(fieldState);
    Field result = new FieldStateChanger().markWaterAsHit(field);
    assert field.equals(result) : "Returned Field should still have state MAST";
  }

  public void testIfMarkWaterAsHitReturnFieldFromParameterIfItWasNotWater2() {
    FieldState fieldState = FieldState.HIT_MAST;
    Field field = new Field(fieldState);
    Field result = new FieldStateChanger().markWaterAsHit(field);
    assert field.equals(result) : "Returned Field should still have state HIT_MAST";
  }

  public void testIfMarkWaterAsHitReturnFieldFromParameterIfItWasNotWater3() {
    FieldState fieldState = FieldState.HIT_WATER;
    Field field = new Field(fieldState);
    Field result = new FieldStateChanger().markWaterAsHit(field);
    assert field.equals(result) : "Returned Field should still have state HIT_WATER";
  }

  public void testIfSetMastOnWaterReturnFieldWithProperState() {
    FieldState fieldState = FieldState.WATER;
    Field field = new Field(fieldState);
    Field expected = new Field(FieldState.MAST);
    Field result = new FieldStateChanger().setMastOnWater(field);
    assert expected.equals(result) : "Returned Field should have state MAST";
  }

  public void testIfSetMastOnWaterReturnFieldFromParameterIfItWasNotWater1() {
    FieldState fieldState = FieldState.MAST;
    Field field = new Field(fieldState);
    Field result = new FieldStateChanger().setMastOnWater(field);
    assert field.equals(result) : "Returned Field should still have state MAST";
  }

  public void testIfSetMastOnWaterReturnFieldFromParameterIfItWasNotWater2() {
    FieldState fieldState = FieldState.HIT_WATER;
    Field field = new Field(fieldState);
    Field result = new FieldStateChanger().setMastOnWater(field);
    assert field.equals(result) : "Returned Field should still have state HIT_WATER";
  }

  public void testIfSetMastOnWaterReturnFieldFromParameterIfItWasNotWater3() {
    FieldState fieldState = FieldState.HIT_MAST;
    Field field = new Field(fieldState);
    Field result = new FieldStateChanger().setMastOnWater(field);
    assert field.equals(result) : "Returned Field should still have state HIT_MAST";
  }

  public void testIfMarkMastAsHitReturnFieldWithProperState() {
    FieldState fieldState = FieldState.MAST;
    Field field = new Field(fieldState);
    Field expected = new Field(FieldState.HIT_MAST);
    Field result = new FieldStateChanger().markMastAsHit(field);
    assert expected.equals(result) : "Returned Field should have state HIT_MAST";
  }

  public void testIfMarkMastAsHitReturnFieldFromParameterIfItWasNotMast1() {
    FieldState fieldState = FieldState.WATER;
    Field field = new Field(fieldState);
    Field expected = new Field(FieldState.HIT_WATER);
    Field result = new FieldStateChanger().markMastAsHit(field);
    assert expected.equals(result) : "Returned Field should have state HIT_WATER";
  }

  public void testIfMarkMastAsHitReturnFieldFromParameterIfItWasNotMast2() {
    FieldState fieldState = FieldState.HIT_WATER;
    Field field = new Field(fieldState);
    Field result = new FieldStateChanger().markMastAsHit(field);
    assert field.equals(result) : "Returned Field should still have state HIT_WATER";
  }

  public void testIfMarkMastAsHitReturnFieldFromParameterIfItWasNotMast3() {
    FieldState fieldState = FieldState.HIT_MAST;
    Field field = new Field(fieldState);
    Field result = new FieldStateChanger().markMastAsHit(field);
    assert field.equals(result) : "Returned Field should still have state HIT_MAST";
  }

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