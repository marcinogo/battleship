package pl.wilki.battleship.turn;

import static org.testng.Assert.*;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @author Jakub Czajka
 */
public class ShipToPlaceTest {

  private ShipToPlace shipToPlace;
   @BeforeMethod
  public void before(){
     shipToPlace = new ShipToPlace();
   }

   @DataProvider
   public Object[][] numberOfTimes(){
   return new Object[][]{{1},{2},{3},{4},{5},{6}};
   }

  @DataProvider
  public Object[][] nextShipSize(){
    return new Object[][]{{1,3},{2,3},{3,2},{4,2},{5,2},{6,1}};
  }

   @Test( dataProvider = "numberOfTimes")
  public void whenNextShipSizeCalledMultipleTimesThenItAlwaysReturnTheSameValue(int numberOfTimes){
    int initialSize = shipToPlace.nextShipSize();
    for (int i = 0; i < numberOfTimes; i++){
      shipToPlace.nextShipSize();
    }
    assertEquals(initialSize,shipToPlace.nextShipSize());
   }

  @Test( dataProvider = "nextShipSize")
  public void whenNextShipSizeCalledMultipleTimesThenNextShipSizeIsGiven(int numberOfTimes, int nextShipSize){

    for (int i = 0; i < numberOfTimes; i++){
      shipToPlace.shipSizeAndIncrement();
    }

    assertEquals(shipToPlace.shipSizeAndIncrement(),nextShipSize);
  }

}