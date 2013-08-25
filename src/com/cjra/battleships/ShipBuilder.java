package com.cjra.battleships;

public class ShipBuilder {
    public static Ship buildShip(ShipType ship, Selection selection) {
        return new Ship(ship, selection.getPositions());
    }
}
