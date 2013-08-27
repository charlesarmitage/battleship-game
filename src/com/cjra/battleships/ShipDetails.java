package com.cjra.battleships;

public class ShipDetails {

    public static int getShipLength(ShipType ship) {
        int length = 0;
        switch(ship)
        {
            case PATROL_BOAT:
                length = 2;
                break;
            case DESTROYER:
                length = 3;
                break;
            case BATTLESHIP:
                length = 4;
                break;
            case AIRCRAFT_CARRIER:
                length = 5;
                break;
        }
        return length;
    }

    public static ShipType getShipForLength(int length) {

        ShipType type = ShipType.NONE;

        switch(length)
        {
            case 2:
                type = ShipType.PATROL_BOAT;
                break;
            case 3:
                type = ShipType.DESTROYER;
                break;
            case 4:
                type = ShipType.BATTLESHIP;
                break;
            case 5:
                type = ShipType.AIRCRAFT_CARRIER;
                break;
            default:
                break;
        }

        return type;
    }
}
