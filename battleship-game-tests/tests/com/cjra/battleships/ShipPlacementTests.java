package com.cjra.battleships;

import org.junit.Test;

import static junit.framework.Assert.assertTrue;

public class ShipPlacementTests extends VerticalSelectionTests {

    @Test
    public void placePatrolBoatOffered(){
        selectTwoCells();

        assertTrue(testView.offerPatrolBoatCalled);
    }
}
