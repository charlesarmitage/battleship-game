package com.cjra.battleships;

import java.util.List;

public class CellPlacer {

    private List<? extends Positionable> deployables;

    public CellPlacer(List<? extends Positionable> ships){
        this.deployables = ships;
    }

    public boolean isAvailable(Position position){
        for(Positionable deployed : deployables){
            for(Position deployedPositions : deployed.getPositions()){
                if(deployedPositions.matches(position.x, position.y)){
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
