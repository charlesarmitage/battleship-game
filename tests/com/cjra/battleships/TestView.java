package com.cjra.battleships;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class TestView implements DeploymentView {
    public CellType[][] latestGrid;
    public ShipType offeredShip = ShipType.NONE;
    public Collection<ShipType> availableShips = new ArrayList<ShipType>();
    public Ship[] deployedShips;
    public List<Position> selection = new ArrayList<Position>();
    public boolean canStartGame = false;

    @Override
    public void displaySelection(Positionable selection) {
        this.selection = selection.getPositions();
    }

    @Override
    public void displayShips(Collection<? extends Positionable> deployedShips) {
        this.deployedShips = deployedShips.toArray(new Ship[0]);
    }

    @Override
    public void offerShipPlacement(ShipType ship) {
        offeredShip = ship;
    }

    @Override
    public void offerGameStart() {
        canStartGame = true;
    }

    @Override
    public void refreshView() {
        this.latestGrid = buildGrid();
        this.latestGrid = getGrid(this.selection);
    }

    @Override
    public void displayAvailableShips(Collection<ShipType> availableShips) {
        this.availableShips = availableShips;
    }

    private CellType[][] getGrid(List<Position> selection) {
        for(Position position : selection){
            latestGrid[position.x][position.y] = CellType.SELECTED;
        }
        for(Ship ship : deployedShips){
            for(Position position : ship.getPositions()){
                latestGrid[position.x][position.y] = CellType.SHIP;
            }
        }

        return latestGrid;
    }

    private CellType[][] buildGrid() {
        CellType[][] grid = new CellType[10][10];
        for(int x = 0; x < 10; x++){
            for(int y = 0; y < 10; y++){
                grid[x][y] = CellType.EMPTY;
            }
        }
        return grid;
    }
}
