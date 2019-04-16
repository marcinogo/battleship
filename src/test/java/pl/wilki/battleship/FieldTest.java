package pl.wilki.battleship;

import org.testng.annotations.Test;
import pl.wilki.battleship.Field.FieldState;

/**
 * @author Marcin Ogorzalek
 */

@Test
public class FieldTest {
  public void testIfFieldHaveWaterState() {
    FieldState fieldState = FieldState.WATER;
    Field field = new Field(fieldState);
    assert field.getFieldState().equals(fieldState) : "Field should have state WATER";
  }

  public void testIfWaterFieldIsProperRepresented() {
    FieldState fieldState = FieldState.WATER;
    Field field = new Field(fieldState);
    assert field.toString().equals("[ ]") : "Field with WATER should be represented as [ ]";
  }

    public void testIfFieldHaveHitWaterState() {
      FieldState fieldState = FieldState.HIT_WATER;
      Field field = new Field(fieldState);
      assert field.getFieldState().equals(fieldState) : "Field should have state WATER";
    }

    public void testIfHitWaterFieldIsProperRepresented() {
      FieldState fieldState = FieldState.HIT_WATER;
      Field field = new Field(fieldState);
      assert field.toString().equals("[O]") : "Field with WATER should be represented as [O]";
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
