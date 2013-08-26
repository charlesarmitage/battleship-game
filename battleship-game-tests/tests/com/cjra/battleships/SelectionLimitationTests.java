package com.cjra.battleships;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class SelectionLimitationTests extends DeploymentScenarios {

    @Test
    public void cannotSelectDeployedShipCells(){
        deploymentController.selectCell(4,4);
        deploymentController.selectCell(4,5);
        deploymentController.placeShip(ShipType.PATROL_BOAT);

        deploymentController.selectCell(4,4);
        deploymentController.selectCell(4,5);

        assertEquals(0, testView.selection.size());
    }

    @Test
    public void deployAircraftCarrierCannotSelectMoreThanFiveCells(){
        deploymentController.resetGrid();
        deploymentController.selectCell(0,0);
        deploymentController.selectCell(0,1);
        deploymentController.selectCell(0,2);
        deploymentController.selectCell(0,3);
        deploymentController.selectCell(0,4);
        deploymentController.placeShip(ShipType.AIRCRAFT_CARRIER);

        deploymentController.selectCell(1,0);
        deploymentController.selectCell(1,1);
        deploymentController.selectCell(1,2);
        deploymentController.selectCell(1,3);
        deploymentController.selectCell(1,4);

        assertEquals(4, testView.selection.size());
    }

    @Test
    public void deployBattleshipCannotSelectMoreThanThreeCells(){
        deployAircraftCarrierCannotSelectMoreThanFiveCells();
        deploymentController.placeShip(ShipType.BATTLESHIP);

        deploymentController.selectCell(2,0);
        deploymentController.selectCell(2,1);
        deploymentController.selectCell(2,2);
        deploymentController.selectCell(2,3);

        assertEquals(3, testView.selection.size());
    }

    @Test
    public void deployDestroyerCannotSelectMoreThanTwoCells(){
        deployBattleshipCannotSelectMoreThanThreeCells();
        deploymentController.placeShip(ShipType.DESTROYER);

        deploymentController.selectCell(3,0);
        deploymentController.selectCell(3,1);
        deploymentController.selectCell(3,2);

        assertEquals(2, testView.selection.size());
    }

    @Test
    public void deployPatrolBoatCannotSelectAnyCells(){
        deployDestroyerCannotSelectMoreThanTwoCells();
        deploymentController.placeShip(ShipType.PATROL_BOAT);

        deploymentController.selectCell(4,0);

        assertEquals(0, testView.selection.size());
    }
}
