package com.cjra.battleships;

import junit.framework.Assert;
import org.junit.Test;
import org.junit.Before;

import java.util.ArrayList;
import java.util.List;

public class ThirdCellSelectionTests extends DeploymentScenarios {

    private final List<Position> expectedSelections = new ArrayList<Position>();

    @Before
    public void selectTwoCells(){
        selectInitialCell(4,4);
        deploymentController.selectCell(4,5);
        expectedSelections.add(new Position(4,4));
        expectedSelections.add(new Position(4,5));
    }

    @Test
    public void  selectCellAtBottom(){
        deploymentController.selectCell(4,6);

        Assert.assertEquals(CellType.SELECTED, testView.latestGrid[4][6]);

        expectedSelections.add(new Position(4,6));
        assertOtherCellsEmpty(expectedSelections.toArray(new Position[0]));
    }

    @Test
    public void selectCellAtTop(){
        deploymentController.selectCell(4,3);

        Assert.assertEquals(CellType.SELECTED, testView.latestGrid[4][3]);

        expectedSelections.add(new Position(4,3));
        assertOtherCellsEmpty(expectedSelections.toArray(new Position[0]));
    }

    @Test
    public void selectCellToRight(){
        deploymentController.selectCell(5,4);

        Assert.assertEquals(CellType.EMPTY, testView.latestGrid[5][4]);
        assertOtherCellsEmpty(expectedSelections.toArray(new Position[0]));
    }

    @Test
    public void selectCellToLeft(){
        deploymentController.selectCell(3,4);

        Assert.assertEquals(CellType.EMPTY, testView.latestGrid[3][4]);
        assertOtherCellsEmpty(expectedSelections.toArray(new Position[0]));
    }
}
