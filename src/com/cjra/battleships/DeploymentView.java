package com.cjra.battleships;

public interface DeploymentView {

    public void displayGrid(CellType [][] grid);
    public void offerPatrolBoatPlacement();
    public void offerShipPlacement(ShipType destroyer);
}
