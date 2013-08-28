package com.cjra.battleships;

import junit.framework.Assert;
import org.junit.Test;
import org.junit.Before;

public class VerticalSelectionTests extends DeploymentScenarios {

    @Before
    public void selectTwoCells(){
        selectInitialCell(4,4);
        deploymentController.selectCell(4,5);
        expectedSelections.add(new Position(4,4));
        expectedSelections.add(new Position(4,5));
    }

    @Test
    public void  selectThirdCellAtBottom(){
        deploymentController.selectCell(4,6);

        Assert.assertEquals(CellType.SELECTED, testView.latestGrid[4][6]);

        expectedSelections.add(new Position(4,6));
        assertOtherCellsEmpty(expectedSelections.toArray(new Position[0]));
    }

    @Test
    public void selectThirdCellAtTop(){
        deploymentController.selectCell(4,3);

        Assert.assertEquals(CellType.SELECTED, testView.latestGrid[4][3]);

        expectedSelections.add(new Position(4,3));
        assertOtherCellsEmpty(expectedSelections.toArray(new Position[0]));
    }

    @Test
    public void selectThirdCellToRight(){
        deploymentController.selectCell(5,4);

        Assert.assertEquals(CellType.EMPTY, testView.latestGrid[5][4]);
        assertOtherCellsEmpty(expectedSelections.toArray(new Position[0]));
    }

    @Test
    public void selectThirdCellToLeft(){
        deploymentController.selectCell(3,4);

        Assert.assertEquals(CellType.EMPTY, testView.latestGrid[3][4]);
        assertOtherCellsEmpty(expectedSelections.toArray(new Position[0]));
    }

    @Test
    public void selectFourthCellAtBottom(){
        selectThirdCellAtTop();

        deploymentController.selectCell(4,6);

        expectedSelections.add(new Position(4,6));
        Assert.assertEquals(CellType.SELECTED, testView.latestGrid[4][6]);
        assertOtherCellsEmpty(expectedSelections.toArray(new Position[0]));
    }

    @Test
    public void selectFourthCellAtTop(){
        selectThirdCellAtBottom();

        deploymentController.selectCell(4,3);

        Assert.assertEquals(CellType.SELECTED, testView.latestGrid[4][3]);
        expectedSelections.add(new Position(4,3));
        assertOtherCellsEmpty(expectedSelections.toArray(new Position[0]));
    }

    @Test
    public void selectFiveCells(){
        selectFourthCellAtTop();

        deploymentController.selectCell(4,7);

        expectedSelections.add(new Position(4,7));
        Assert.assertEquals(CellType.SELECTED, testView.latestGrid[4][7]);
        assertOtherCellsEmpty(expectedSelections.toArray(new Position[0]));
    }

    @Test
    public void resetGridClearsGrid(){
        resetGrid();

        assertOtherCellsEmpty(new Position[0]);
    }
}
