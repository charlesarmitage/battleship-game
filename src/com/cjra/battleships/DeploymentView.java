package com.cjra.battleships;

import java.util.Collection;

public interface DeploymentView {

    public void displayGrid(CellType [][] grid);
    public void offerShipPlacement(ShipType ship);
    public void displayAvailableShips(Collection<ShipType> availableShips);
}
