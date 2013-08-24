package com.cjra.battleships;

import java.util.ArrayList;
import java.util.Collection;

public class TestView implements DeploymentView {
    public CellType[][] latestGrid;
    public ShipType offeredShip = ShipType.NONE;
    public Collection<ShipType> availableShips = new ArrayList<ShipType>();
    public Ship[] deployedShips;

    @Override
    public void displayGrid(CellType[][] grid, Collection<Ship> deployedShips) {
        this.latestGrid = grid;
        this.deployedShips = deployedShips.toArray(new Ship[0]);
    }

    @Override
    public void offerShipPlacement(ShipType ship) {
        offeredShip = ship;
    }

    @Override
    public void displayAvailableShips(Collection<ShipType> availableShips) {
        this.availableShips = availableShips;
    }
}
