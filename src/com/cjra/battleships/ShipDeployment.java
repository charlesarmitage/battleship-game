package com.cjra.battleships;

/**
 * Created by cjra on 31/08/13.
 */
public interface ShipDeployment {
    void refresh();

    void resetGrid();

    void selectCell(int x, int y);

    void placeShip(ShipType ship);
}
