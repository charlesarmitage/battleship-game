package com.cjra.battleships;

public class DeploymentModel {
    private final CellType [][] grid = new CellType[10][10];

    public DeploymentModel(){
        for(int x = 0; x < 10; x++){
            for(int y = 0; y < 10; y++){
                grid[x][y] = CellType.EMPTY;
            }
        }
    }

    public boolean isCellSelected(int x, int y) {
        return grid[x][y] == CellType.SELECTED;
    }

    public void selectCell(int x, int y) {
        grid[x][y] = CellType.SELECTED;
    }

    public void clearCell(int x, int y) {
        grid[x][y] = CellType.EMPTY;
    }

    public CellType[][] getGrid() {
        return grid;
    }
}
