package com.cjra.battleships;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class ShipDeploymentTests extends VerticalSelectionTests {

    @Test
    public void noShipsPlaced(){

        assertEquals(0, testView.deployedShips.length);
    }

    @Test
    public void placePatrolBoat(){
        deploymentController.placeShip(ShipType.PATROL_BOAT);

        assertEquals(CellType.SHIP, testView.latestGrid[4][4]);
        assertEquals(CellType.SHIP, testView.latestGrid[4][5]);
        assertOtherCellsEmpty(expectedSelections.toArray(new Position[0]));
    }

    @Test
    public void deployPatrolBoat(){
        deploymentController.placeShip(ShipType.PATROL_BOAT);

        assertEquals(ShipType.PATROL_BOAT, testView.deployedShips[0].getType());
    }
}
