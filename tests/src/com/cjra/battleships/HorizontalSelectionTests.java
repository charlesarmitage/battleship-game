package com.cjra.battleships;

import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class HorizontalSelectionTests extends DeploymentScenarios {

    @Before
    public void selectTwoCells(){
        selectInitialCell(4,4);
        deploymentController.selectCell(5,4);
        expectedSelections.add(new Position(4,4));
        expectedSelections.add(new Position(5,4));
    }

    @After
    public void otherCellsShouldBeEmpty(){
        assertOtherCellsEmpty(expectedSelections.toArray(new Position[0]));
    }

    @Test
    public void selectThirdCellToLeft(){
        deploymentController.selectCell(3,4);

        Assert.assertEquals(CellType.SELECTED, testView.latestGrid[3][4]);
        expectedSelections.add(new Position(3,4));
    }

    @Test
    public void selectThirdCellToRight(){
        deploymentController.selectCell(6,4);

        Assert.assertEquals(CellType.SELECTED, testView.latestGrid[6][4]);
        expectedSelections.add(new Position(6,4));
    }

    @Test
    public void selectThirdCellAbove(){
        deploymentController.selectCell(4,3);

        Assert.assertEquals(CellType.EMPTY, testView.latestGrid[4][3]);
    }

    @Test
    public void selectThirdCellBelow(){
        deploymentController.selectCell(4,5);

        Assert.assertEquals(CellType.EMPTY, testView.latestGrid[4][5]);
    }

    @Test
    public void selectFourthCellToRight(){
        selectThirdCellToLeft();

        deploymentController.selectCell(6,4);

        Assert.assertEquals(CellType.SELECTED, testView.latestGrid[6][4]);
        expectedSelections.add(new Position(6,4));
    }

    @Test
    public void selectFourthCellToLeft(){
        selectThirdCellToRight();

        deploymentController.selectCell(3,4);

        Assert.assertEquals(CellType.SELECTED, testView.latestGrid[3][4]);
        expectedSelections.add(new Position(3,4));
    }
}
