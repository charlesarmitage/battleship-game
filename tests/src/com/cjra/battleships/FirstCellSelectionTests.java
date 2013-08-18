package com.cjra.battleships;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

public class FirstCellSelectionTests extends DeploymentScenarios {

    @Before
    public void setup(){
        resetGrid();
    }

    @Test
    public void selectingACellShouldDisplayAsSelected(){
        deploymentController.selectCell(1,1);

        Assert.assertEquals(CellType.SELECTED, testView.latestGrid[1][1]);
        assertOtherCellsEmpty(new Position[]{new Position(1, 1)});
    }

    @Test
    public void selectingASingleSelectedCellShouldClearCell(){
        deploymentController.selectCell(1,1);
        deploymentController.selectCell(1,1);

        Assert.assertEquals(CellType.EMPTY, testView.latestGrid[1][1]);
        assertOtherCellsEmpty(new Position[]{});
    }
}
