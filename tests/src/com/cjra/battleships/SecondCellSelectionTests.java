package com.cjra.battleships;

import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SecondCellSelectionTests extends DeploymentScenarios{

    @Before
    public void setup() {
        selectInitialCell(4, 4);
    }

    @After
    public void initialCellStillSelected(){
        Assert.assertEquals(CellType.SELECTED, testView.latestGrid[4][4]);
    }

    @Test
    public void testSelectLeftCell() {
        deploymentController.selectCell(3, 4);

        Assert.assertEquals(CellType.SELECTED, testView.latestGrid[3][4]);
        assertOtherCellsEmpty(new Position[]{new Position(3,4), new Position(4,4)});
    }

    @Test
    public void selectAboveCell() {
        deploymentController.selectCell(4, 3);

        Assert.assertEquals(CellType.SELECTED, testView.latestGrid[4][3]);
        assertOtherCellsEmpty(new Position[]{new Position(4,3), new Position(4,4)});
    }


    @Test
    public void selectRightCell() {
        deploymentController.selectCell(5, 4);

        Assert.assertEquals(CellType.SELECTED, testView.latestGrid[5][4]);
        assertOtherCellsEmpty(new Position[]{new Position(5,4), new Position(4,4)});
    }

    @Test
    public void selectBelowCell() {
        deploymentController.selectCell(4, 5);

        Assert.assertEquals(CellType.SELECTED, testView.latestGrid[4][5]);
        assertOtherCellsEmpty(new Position[]{new Position(4,5), new Position(4,4)});
    }
}
