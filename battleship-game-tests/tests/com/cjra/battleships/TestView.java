package com.cjra.battleships;

import java.util.ArrayList;
import java.util.List;

public class TestView implements DeploymentView {
    public CellType[][] latestGrid;
    public boolean offerPatrolBoatCalled = false;
    public ShipType offeredShip = ShipType.NONE;

    @Override
    public void displayGrid(CellType[][] grid) {
        this.latestGrid = grid;
    }

    @Override
    public void offerPatrolBoatPlacement() {
        offerPatrolBoatCalled = true;
    }

    @Override
    public void offerShipPlacement(ShipType ship) {
        offeredShip = ship;
    }
}
