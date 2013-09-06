package com.cjra.battleships;

import java.util.List;

public abstract class Positionable {
    public abstract List<Position> getPositions();

    public Position start(){
        return getPositions().get(0);
    }

    public Position end(){
        return getPositions().get(getPositions().size()-1);
    }

    public boolean isHorizontal() {
        return getPositions().size() >= 2 && getPositions().get(0).y == getPositions().get(1).y;
    }

    public boolean isVertical() {
        return getPositions().size() >= 2 && getPositions().get(0).x == getPositions().get(1).x;
    }
}
