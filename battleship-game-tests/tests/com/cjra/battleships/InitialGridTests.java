package com.cjra.battleships;

import org.junit.Test;

public class InitialGridTests extends DeploymentScenarios {

    @Test
    public void initialGridShouldBeEmptyWhenReset(){
        deploymentController.resetGrid();

        assertOtherCellsEmpty(new Position[]{});
    }
}
