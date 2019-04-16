package pl.wilki.battleship;


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

  public void testIfSetMastOnWaterReturnFieldWithProperState() {
    FieldState fieldState = FieldState.WATER;
    Field field = new Field(fieldState);
    Field expected = new Field(FieldState.MAST);
    Field result = new FieldStateChanger().setMastOnWater(field);
    assert expected.equals(result) : "Returned Field should have state MAST";
  }

  public void testIfMarkMastAsHitReturnFieldWithProperState() {
    FieldState fieldState = FieldState.MAST;
    Field field = new Field(fieldState);
    Field expected = new Field(FieldState.HIT_MAST);
    Field result = new FieldStateChanger().markMastAsHit(field);
    assert expected.equals(result) : "Returned Field should have state HIT_MAST";
  }
}