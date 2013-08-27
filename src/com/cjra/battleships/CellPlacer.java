package com.cjra.battleships;

import java.util.List;

public class CellPlacer {

    private List<Ship> deployables;

    public CellPlacer(List<Ship> ships){
        this.deployables = ships;
    }

    public boolean isAvailable(Position position){
        for(Ship ship : deployables){
            for(Position shipPosition : ship.getPositions()){
                if(shipPosition.matches(position.x, position.y)){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isInBounds(int x, int y) {
        return x >= 0 && x < 10 && y >= 0 && y < 10;
    }
}
