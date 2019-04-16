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
    assert field.toString().equals("[ ]");
  }
}
