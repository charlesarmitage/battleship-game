package com.cjra.battleships;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class DeployedShipSelectionTests extends ShipDeploymentTests {

    @Test
    public void cannotSelectDeployedShipCells(){
        placePatrolBoat();

        deploymentController.selectCell(4,4);
        deploymentController.selectCell(4,5);

        assertEquals(0, testView.selection.size());
    }
}
