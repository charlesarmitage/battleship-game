package com.cjra.battleships;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

/**
 * Created by cjra on 06/09/13.
 */
public class PositionableTests {

    @Test
    public void hasStartPosition(){
        List<Position> positions = new ArrayList<Position>();
        positions.add(new Position(1,1));
        positions.add(new Position(1,2));
        positions.add(new Position(1,3));

        Positionable positionable = new Ship(ShipType.DESTROYER, positions);

        assertTrue(new Position(1, 1).matches(positionable.start()));
    }

    @Test
    public void hasEndPosition(){
        List<Position> positions = new ArrayList<Position>();
        positions.add(new Position(1,1));
        positions.add(new Position(1,2));
        positions.add(new Position(1,3));

        Positionable positionable = new Ship(ShipType.DESTROYER, positions);

        assertTrue(new Position(1, 3).matches(positionable.end()));
    }
}
