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

  public void testIfMarkMastAsHitReturnFieldFromParameterIfItWasNotWater1() {
    FieldState fieldState = FieldState.WATER;
    Field field = new Field(fieldState);
    Field result = new FieldStateChanger().markMastAsHit(field);
    assert field.equals(result) : "Returned Field should still have state WATER";
  }

  public void testIfMarkMastAsHitReturnFieldFromParameterIfItWasNotWater2() {
    FieldState fieldState = FieldState.HIT_WATER;
    Field field = new Field(fieldState);
    Field result = new FieldStateChanger().markMastAsHit(field);
    assert field.equals(result) : "Returned Field should still have state HIT_WATER";
  }

  public void testIfMarkMastAsHitReturnFieldFromParameterIfItWasNotWater3() {
    FieldState fieldState = FieldState.HIT_MAST;
    Field field = new Field(fieldState);
    Field result = new FieldStateChanger().markMastAsHit(field);
    assert field.equals(result) : "Returned Field should still have state HIT_MAST";
  }
}