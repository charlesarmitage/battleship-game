package com.cjra.battleships;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
            sortSelections();

            Position start = selections.get(0);
            Position end = selections.get(selections.size()-1);
            potentialSelections.clear();
            if(isVertical()){
                addPotentialSelection(start.x, start.y - 1);
                addPotentialSelection(end.x, end.y + 1);
            }
            else if(isHorizontal()){
                addPotentialSelection(start.x - 1, start.y);
                addPotentialSelection(end.x + 1, end.y);
            }
        }
    }

    private boolean isHorizontal() {
        return selections.get(0).y == selections.get(1).y;
    }

    private boolean isVertical() {
        return selections.get(0).x == selections.get(1).x;
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

    private void sortSelections(){
        Collections.sort(selections, getVerticalComparator());
    }

    private Comparator<Position> getVerticalComparator() {
        return new Comparator<Position>() {
            public int compare(Position one, Position other) {
                return one.y - other.y;
            }
        };
    }
}
