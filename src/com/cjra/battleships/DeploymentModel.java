package com.cjra.battleships;

public class DeploymentModel {
    private Selection selection = new Selection();

    public CellType[][] getGrid() {
        CellType[][] currentGrid = buildGrid();
        for(Position position : selection.getPositions()){
            currentGrid[position.x][position.y] = CellType.SELECTED;
        }
        return currentGrid;
    }

    public void pickCell(int x, int y){

        if(!selection.isSelected(x, y)) {
            selection.select(x, y);
        }
        else {
            selection.clear(x, y);
        }
    }

    public boolean isShipReadyToPlace() {
        return selection.size() == 2;
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
