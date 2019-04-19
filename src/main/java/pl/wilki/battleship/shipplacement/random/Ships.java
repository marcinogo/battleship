package pl.wilki.battleship.shipplacement.random;

import java.util.List;

/**
 * @author Ola Podorska
 */
class Ships {

  private List<Integer> ships;

  public Ships() {
  }

  Ships(List<Integer> ships) {
    this.ships = ships;
  }

  public List<Integer> getShips() {
    return ships;
  }

  public void setShips(List<Integer> ships) {
    this.ships = ships;
  }

  public Integer getShip(int index) {
    return ships.get(index);
  }
}
