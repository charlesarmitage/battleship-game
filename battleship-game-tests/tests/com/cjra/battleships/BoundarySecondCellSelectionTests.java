package com.cjra.battleships;

import junit.framework.Assert;
import org.junit.Test;

public class BoundarySecondCellSelectionTests extends DeploymentScenarios {

    @Test
    public void selectCellsNextToLeftBoundary(){
        selectInitialCell(0, 4);

        deploymentController.selectCell(0, 5);

        Assert.assertEquals(CellType.SELECTED, testView.latestGrid[0][4]);
        Assert.assertEquals(CellType.SELECTED, testView.latestGrid[0][5]);
        assertOtherCellsEmpty(new Position[]{new Position(0, 4), new Position(0, 5)});
    }

    @Test
    public void selectCellsNextToTopBoundary(){
        selectInitialCell(4, 0);

        deploymentController.selectCell(5, 0);

        Assert.assertEquals(CellType.SELECTED, testView.latestGrid[4][0]);
        Assert.assertEquals(CellType.SELECTED, testView.latestGrid[5][0]);
        assertOtherCellsEmpty(new Position[]{new Position(4, 0), new Position(5, 0)});
    }

    @Test
    public void selectCellsNextToRightBoundary(){
        selectInitialCell(9, 4);

        deploymentController.selectCell(9, 5);

        Assert.assertEquals(CellType.SELECTED, testView.latestGrid[9][4]);
        Assert.assertEquals(CellType.SELECTED, testView.latestGrid[9][5]);
        assertOtherCellsEmpty(new Position[]{new Position(9, 4), new Position(9, 5)});
    }

    @Test
    public void selectCellsNextToBottomBoundary(){
        selectInitialCell(4, 9);

        deploymentController.selectCell(5, 9);

        Assert.assertEquals(CellType.SELECTED, testView.latestGrid[4][9]);
        Assert.assertEquals(CellType.SELECTED, testView.latestGrid[5][9]);
        assertOtherCellsEmpty(new Position[]{new Position(4, 9), new Position(5, 9)});
    }
}
