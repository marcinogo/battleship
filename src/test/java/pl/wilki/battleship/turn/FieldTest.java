package pl.wilki.battleship.turn;

import static org.testng.Assert.*;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @author Marcin Ogorzalek
 */
@Test
public class FieldTest {

  @DataProvider
  public static Object[][] givenFieldAndExpectedColorRepresentation(){
      return new Object[][] {
          {Field.WATER, "#FEFDFD"},
          {Field.WATER_SHOOTED, "#10DDE8"},
          {Field.SHIP, "#111111"},
          {Field.SHIP_SHOOTED, "#F50D18"}
      };
  }

  @Test(dataProvider = "givenFieldAndExpectedColorRepresentation")
  public void testIfToStringReturnProperFieldRepresentation(Field givenField,
      String expectedRepresentation) {
    String resultRepresentation = givenField.toString();
    String failedAssertionMessage = String.format("Field should be represented by %s, but is by %s",
        expectedRepresentation, resultRepresentation);
    assertEquals(resultRepresentation, expectedRepresentation, failedAssertionMessage);
  }
}