package com.cjra.battleships;

import junit.framework.Assert;

import java.util.ArrayList;
import java.util.List;

public class DeploymentScenarios {
    public final TestView testView;
    public final DeploymentController deploymentController;
    protected final List<Position> expectedSelections = new ArrayList<Position>();

    public DeploymentScenarios(){
        testView = new TestView();
        DeploymentModel deploymentModel = new DeploymentModel();
        deploymentController = new DeploymentController(testView, deploymentModel);
    }

    public void resetGrid(){
        deploymentController.resetGrid();
    }

    public void selectInitialCell(int x, int y) {
        resetGrid();
        deploymentController.selectCell(x, y);
    }

    protected void assertOtherCellsEmpty(Position[] positions) {
        for(int x = 0; x < 10; x++){
            for(int y = 0; y < 10; y++){
                if(!isExpectedAsOccupied(positions, x, y))  {
                    String msg = "Cell: " + x + ", " + y + " should be empty.";
                    Assert.assertEquals(msg, CellType.EMPTY, testView.latestGrid[x][y]);
                }
            }
        }
    }

    private boolean isExpectedAsOccupied(Position[] expected, int x, int y) {
        for(int i = 0; i < expected.length; i++){
            if(expected[i].x == x && expected[i].y == y){
                return  true;
            }
        }
        return false;
    }
}
