package com.cjra.battleships;

public class DeploymentController {
    private final DeploymentView view;
    private final DeploymentModel model;

    public DeploymentController(DeploymentView view, DeploymentModel model){
        this.view = view;
        this.model = model;
    }

    public void resetGrid() {
        view.displayGrid(model.getGrid());
    }

    public void selectCell(int x, int y) {
        model.pickCell(x, y);
        view.displayGrid(model.getGrid());
    }
}
