package com.cjra.battleships;

import java.util.ArrayList;
import java.util.List;

public class Selection {
    private final List<Position> selections = new ArrayList<Position>();

    public boolean isEmpty(){

        return selections.size() == 0;
    }

    public void select(int x, int y){

        selections.add(new Position(x, y));
    }

    public boolean isSelected(int x, int y) {

        for(Position position : selections){
            if(position.x == x && position.y == y){
                return true;
            }
        }
        return false;
    }

    public void clear(int x, int y) {
        for(Position selection : selections){
            if(selection.x == x && selection.y == y){
                selections.remove(selection);
                return;
            }
        }
    }

    public boolean isAdjacentToSelection(int x, int y) {
        List<Position> adjacentCells = new ArrayList<Position>();
        adjacentCells.add(new Position(x-1, y));
        adjacentCells.add(new Position(x, y-1));
        adjacentCells.add(new Position(x+1, y));
        adjacentCells.add(new Position(x, y+1));

        for(Position cell : adjacentCells){
            if(isInBounds(cell.x, cell.y)) {
                if(isSelected(cell.x, cell.y)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isInBounds(int x, int y) {
        return x >= 0 && x < 10 && y >= 0 && y < 10;
    }

    public Iterable<? extends Position> getPositions() {
        return selections;
    }
}
