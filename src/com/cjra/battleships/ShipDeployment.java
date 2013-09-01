package com.cjra.battleships;

/**
 * Created by cjra on 31/08/13.
 */
public interface ShipDeployment {
    void resetGrid();

    void selectCell(int x, int y);

    void placeShip(ShipType ship);
}
