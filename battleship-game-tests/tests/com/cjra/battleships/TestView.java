package com.cjra.battleships;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class TestView implements DeploymentView {
    public CellType[][] latestGrid;
    public ShipType offeredShip = ShipType.NONE;
    public Collection<ShipType> availableShips = new ArrayList<ShipType>();

    @Override
    public void displayGrid(CellType[][] grid) {
        this.latestGrid = grid;
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
