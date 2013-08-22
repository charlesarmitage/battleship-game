package com.cjra.battleships;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

public class ShipPlacementTests extends VerticalSelectionTests {

    @Test
    public void noCellsSelected(){
        deploymentController.resetGrid();

        assertEquals(ShipType.NONE, testView.offeredShip);
    }

    @Test
    public void oneCellSelected(){
        resetGrid();
        selectInitialCell(4,3);

        assertEquals(ShipType.NONE, testView.offeredShip);
    }

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

    @Test
    public void placeBattleshipOffered(){
        selectFourthCellAtTop();

        assertEquals(ShipType.BATTLESHIP, testView.offeredShip);
    }

    @Test
    public void placeAircraftCarrierOffered(){
        selectFiveCells();

        assertEquals(ShipType.AIRCRAFT_CARRIER, testView.offeredShip);
    }
}
