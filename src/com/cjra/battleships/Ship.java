package com.cjra.battleships;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ship {
    private final ShipType type;
    private List<Position> positions = new ArrayList< Position >();

    public Ship(ShipType type, List<Position> positions) {
        this.type = type;
        this.positions = positions;
    }

    public List<Position> getPositions() {
        return Collections.unmodifiableList(positions);
    }

    public ShipType getType() {
        return type;
    }
}
