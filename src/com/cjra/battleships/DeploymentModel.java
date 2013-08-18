package com.cjra.battleships;

import java.util.ArrayList;
import java.util.List;

public class DeploymentModel {
    private final CellType [][] grid = new CellType[10][10];
    int x = -2;
    int y = -2;

    public DeploymentModel(){
        for(int x = 0; x < 10; x++){
            for(int y = 0; y < 10; y++){
                grid[x][y] = CellType.EMPTY;
            }
        }
    }

    public CellType[][] getGrid() {
        return grid;
    }

    public void pickCell(int x, int y){

        if(!isCellSelected(x, y)) {
            if(isNoSelectionMade() || isAdjacentToSelection(x, y)) {
                selectCell(x, y);
                this.x = x;
                this.y = y;
            }
        }
        else {
            clearCell(x, y);
        }
    }

    private boolean isAdjacentToSelection(int x, int y) {
        List<Position> adjacentCells = new ArrayList<Position>();
        adjacentCells.add(new Position(x-1, y));
        adjacentCells.add(new Position(x, y-1));
        adjacentCells.add(new Position(x+1, y));
        adjacentCells.add(new Position(x, y+1));

        for(Position cell : adjacentCells){
            if(isCellSelected(cell.x, cell.y)){
                return true;
            }
        }
        return false;
    }

    private boolean isNoSelectionMade() {
        return x == -2 && y == -2;
    }

    private boolean isCellSelected(int x, int y) {
        return grid[x][y] == CellType.SELECTED;
    }

    private void selectCell(int x, int y) {
        grid[x][y] = CellType.SELECTED;
    }

    private void clearCell(int x, int y) {
        grid[x][y] = CellType.EMPTY;
    }
}
