package pl.wilki.battleship.board;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pl.wilki.battleship.board.Field.FieldState;

/**
 * @author Marcin Ogorzalek
 */

@Test
public class FieldTest {

  @DataProvider
  public static Object[][] provideDateToFieldCreation() {
    return new Object[][]{
        {FieldState.WATER, "[ ]"},
        {FieldState.HIT_WATER, "[O]"},
        {FieldState.MAST, "[*]"},
        {FieldState.HIT_MAST, "[X]"},
    };
  }

  @Test(dataProvider = "provideDateToFieldCreation")
  public void testIfFieldHaveCorrectState(FieldState fieldState, String representation) {
    Field field = new Field(fieldState);
    assert field.getFieldState().equals(fieldState) : String.format("Field should have state %s",
        fieldState.name());
  }

  @Test(dataProvider = "provideDateToFieldCreation")
  public void testIfFieldIsProperRepresented(FieldState fieldState, String representation) {
    Field field = new Field(fieldState);
    assert field.toString().equals(representation) : String.format("Field with %s should be"
        + " represented as %s", fieldState.name(), representation);
  }

  public void testIfTwoFieldsWithWaterAreEqual() {
    FieldState fieldState = FieldState.WATER;
    Field field1 = new Field(fieldState);
    Field field2 = new Field(fieldState);
    assert field1.equals(field2) : "Fields should be equals";
  }

  public void testIfFieldIsEqualToItself() {
    FieldState fieldState = FieldState.WATER;
    Field field = new Field(fieldState);
    assert field.equals(field) : "Fields should be equals";
  }

  public void testIfFieldIsNotEqualToNull() {
    FieldState fieldState = FieldState.WATER;
    Field field = new Field(fieldState);
    assert !field.equals(null) : "Fields should not be equals";
  }

  public void testIfFieldIsNotEqualToAnyObject1() {
    FieldState fieldState = FieldState.WATER;
    Field field = new Field(fieldState);
    assert !field.equals(new Object()) : "Fields should not be equals";
  }

  public void testIfFieldIsNotEqualToAnyObject2() {
    FieldState fieldState = FieldState.WATER;
    Field field = new Field(fieldState);
    assert !field.equals("[ ]") : "Fields should not be equals";
  }

  public void testIfFieldsWithWaterAndNullAreNotEqual() {
    FieldState fieldState = FieldState.WATER;
    Field field1 = new Field(fieldState);
    Field field2 = new Field(null);
    assert !field1.equals(field2) : "Fields should not be equals";
  }

  public void testIfFieldsWithWaterAndHitWaterAreNotEqual() {
    FieldState fieldState1 = FieldState.WATER;
    FieldState fieldState2 = FieldState.HIT_WATER;
    Field field1 = new Field(fieldState1);
    Field field2 = new Field(fieldState2);
    assert !field1.equals(field2) : "Fields should not be equals";
  }

  public void testIfTwoFieldsWithWaterHaveEqualHashcode() {
    FieldState fieldState = FieldState.WATER;
    Field field1 = new Field(fieldState);
    Field field2 = new Field(fieldState);
    assert field1.hashCode() == field2.hashCode() : "Fields hashCode should be equals";
  }

  public void testIfFieldWithWaterHaveEqualHashcodeToItself() {
    FieldState fieldState = FieldState.WATER;
    Field field = new Field(fieldState);
    assert field.hashCode() == field.hashCode() : "Fields hashCode should be equals";
  }

  public void testIfTwoFieldsWithWaterAndNullHaveNotEqualHashcode() {
    FieldState fieldState = FieldState.WATER;
    Field field1 = new Field(fieldState);
    Field field2 = new Field(null);
    assert field1.hashCode() != field2.hashCode() : "Fields hashCode should be different";
  }

  public void testIfTwoFieldsWithWaterAndHitWaterHaveNotEqualHashcode() {
    FieldState fieldState1 = FieldState.WATER;
    FieldState fieldState2 = FieldState.HIT_WATER;
    Field field1 = new Field(fieldState1);
    Field field2 = new Field(fieldState2);
    assert field1.hashCode() != field2.hashCode() : "Fields hashCode should be different";
  }
}
