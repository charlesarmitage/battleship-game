package com.cjra.battleships;

import java.util.Collection;
import java.util.List;

public interface DeploymentView {

    public void displaySelection(List<Position> selection);
    public void displayGrid(CellType[][] grid, Collection<Ship> deployedShips);
    public void offerShipPlacement(ShipType ship);
    public void displayAvailableShips(Collection<ShipType> availableShips);
}
