package com.cjra.battleships;

import java.util.ArrayList;
import java.util.List;

public class Selection {
    private final List<Position> selections = new ArrayList<Position>();
    private final List<Position> potentialSelections = new ArrayList<Position>();

    public Iterable<? extends Position> getPositions() {
        return selections;
    }

    public void select(int x, int y){

        if(isPotentialSelection(x, y)) {
            selections.add(new Position(x, y));
            updatePotentialSelections(x, y);
        }
    }

    public void clear(int x, int y) {
        for(Position selection : selections){
            if(selection.matches(x, y)){
                selections.remove(selection);
                return;
            }
        }
    }

    public boolean isSelected(int x, int y) {

        for(Position position : selections){
            if(position.matches(x, y)){
                return true;
            }
        }
        return false;
    }

    private boolean isEmpty(){

        return selections.size() == 0;
    }

    private boolean isPotentialSelection(int x, int y) {

        if(isEmpty()){
            return true;
        }

        if(!isInBounds(x, y)){
            return false;
        }

        for(Position cell : potentialSelections){
            if(cell.matches(x, y)){
                return true;
            }
        }
        return false;
    }

    private void updatePotentialSelections(int x, int y) {
        if(selections.size() == 1){
            addPotentialSelection(x - 1, y);
            addPotentialSelection(x, y - 1);
            addPotentialSelection(x + 1, y);
            addPotentialSelection(x, y + 1);
        }
        if(selections.size() > 1){
            Position start = selections.get(0);
            Position end = selections.get(selections.size()-1);
            potentialSelections.clear();
            addPotentialSelection(start.x, start.y - 1);
            addPotentialSelection(end.x, end.y + 1);
        }
    }

    private void addPotentialSelection(int x, int y) {

        if(!isInBounds(x, y)){
            return;
        }
        potentialSelections.add(new Position(x, y));
    }

    private boolean isInBounds(int x, int y) {
        return x >= 0 && x < 10 && y >= 0 && y < 10;
    }
}
