package pl.wilki.battleship.turn;

import static org.testng.Assert.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @author Jakub Czajka
 */
public class ShipPlacementValidatorTest {
  private ShipPlacementValidator validator;

  @BeforeMethod
  public void before(){
    List<Integer> validateFields = IntStream.rangeClosed(0,99).boxed().collect(Collectors.toList());
    validator = new ShipPlacementValidator(new ShipToPlace(), new ValidFields(validateFields));
  }

@DataProvider
public Object[][] correctVerticalShips(){
return new Object[][]{{0,true,1, Collections.singletonList(0)},
    {33,true,4, Arrays.asList(33,23,13,3)},
    {76,true,2, Arrays.asList(76,66)},
    {58,true,3, Arrays.asList(58,48,38)},
    {99,true,2, Arrays.asList(99,89)},
    {56,true,1, Collections.singletonList(56)}};
}
  @DataProvider
  public Object[][] correctHorizontalShips(){
    return new Object[][]{{0,true,1,Collections.singletonList(0)},
        {33,false,4, Arrays.asList(33,34,35,36)},
        {76,false,2, Arrays.asList(76,77)},
        {57,false,3, Arrays.asList(57,58,59)},
        {92,false,2, Arrays.asList(92,93)},
        {56,false,1, Collections.singletonList(56)}};
  }

  @DataProvider
  public Object[][] correctVerticalField(){
  return new Object[][]{{48,true,2},
      {33,true,4},
      {20,true,3},
      {89,true,1},
      {74,true,3},
      {25,true,2}};
  }

  @DataProvider
  public Object[][] correctHorizontalField(){
    return new Object[][]{{1,false,2},
        {25,false,4},
        {20,false,3},
        {89,false,1},
        {74,false,3},
        {25,false,2}};
  }

  @DataProvider
  public Object[][] incorrectHorizontalField(){
    return new Object[][]{{9,false,2},
        {27,false,4},
        {28,false,3},
        {89,false,3},
        {78,false,3},
        {29,false,2}};
  }

  @DataProvider
  public Object[][] incorrectVerticalField(){
    return new Object[][]{{1,true,2},
        {10,true,4},
        {13,true,3},
        {11,true,4},
        {19,true,3},
        {8,true,2}};
  }

  @Test(dataProvider = "correctHorizontalField")
  public void whenHorizontalPlacementIfProperFieldIsGivenReturnTrue(int field, boolean verticalPlacement, int shipSize){
    assertTrue(validator.isFieldCorrect(field,verticalPlacement,shipSize));
  }

  @Test(dataProvider = "incorrectHorizontalField")
  public void whenHorizontalPlacementIfInvalidFieldIsGivenReturnFalse(int field, boolean verticalPlacement, int shipSize){
    assertFalse(validator.isFieldCorrect(field,verticalPlacement,shipSize));
  }

  @Test(dataProvider = "correctVerticalField")
  public void whenVerticalPlacementIfProperFieldIsGivenReturnTrue(int field, boolean verticalPlacement, int shipSize){
    assertTrue(validator.isFieldCorrect(field,verticalPlacement,shipSize));
  }

  @Test(dataProvider = "incorrectVerticalField")
  public void whenVerticalPlacementIfInvalidFieldIsGivenReturnFalse(int field, boolean verticalPlacement, int shipSize) {
    assertFalse(validator.isFieldCorrect(field, verticalPlacement, shipSize));
  }

  @Test(dataProvider = "correctVerticalShips")
  public void whenVerticalShipIsPlacedThenCorrectListOfFieldsReturned(int field, boolean verticalPlacement,int shipSize, List<Integer> correctShipFields){
    List<Integer> shipFields = validator.createShip(field,verticalPlacement,shipSize);
  assertEquals(correctShipFields,shipFields);
  }


  @Test(dataProvider = "correctHorizontalShips")
  public void whenHorizontalShipIsPlacedThenCorrectListOfFieldsReturned(int field, boolean verticalPlacement,int shipSize, List<Integer> correctShipFields){
    List<Integer> shipFields = validator.createShip(field,verticalPlacement,shipSize);
    assertEquals(correctShipFields,shipFields);
  }

}