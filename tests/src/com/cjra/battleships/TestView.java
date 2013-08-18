package com.cjra.battleships;

import java.util.ArrayList;
import java.util.List;

public class TestView implements DeploymentView {
    public CellType[][] latestGrid;

    @Override
    public void displayGrid(CellType[][] grid) {
        this.latestGrid = grid;
    }
}
