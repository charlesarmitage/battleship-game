package com.cjra.battleships;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class ClearHorizontalSelectionTests extends HorizontalSelectionTests{

    @Test
    public void clearLeftHandCell(){
        selectFourthCellToRight();
        assertEquals(CellType.SELECTED, testView.latestGrid[3][4]);

        deploymentController.selectCell(3,4);

        assertEquals(CellType.EMPTY, testView.latestGrid[3][4]);
    }

    @Test
    public void clearRightHandCell(){
        selectFourthCellToRight();
        assertEquals(CellType.SELECTED, testView.latestGrid[6][4]);

        deploymentController.selectCell(6,4);

        assertEquals(CellType.EMPTY, testView.latestGrid[6][4]);
    }

    @Test
    public void tryClearMiddleCell(){
        selectFourthCellToRight();

        deploymentController.selectCell(4,4);

        assertEquals(CellType.SELECTED, testView.latestGrid[4][4]);
    }
}
