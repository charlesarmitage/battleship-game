package com.cjra.battleships;

import java.util.ArrayList;
import java.util.List;

public class Ship {
    private final ShipType type;
    private List<Position> positions = new ArrayList< Position >();

    public Ship(ShipType type, Position start, Position end) {
        this.type = type;
        positions.add(start);
        positions.add(end);
    }

    public Iterable<Position> getPositions() {
        return positions;
    }

    public ShipType getType() {
        return type;
    }
}
