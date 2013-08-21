package com.cjra.battleships;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

public class ShipPlacementTests extends VerticalSelectionTests {

    @Test
    public void placePatrolBoatOffered(){
        selectTwoCells();

        assertEquals(ShipType.PATROL_BOAT, testView.offeredShip);
    }

    @Test
    public void placeDestroyerOffered(){
        selectThirdCellAtBottom();

        assertEquals(ShipType.DESTROYER, testView.offeredShip);
    }
}
