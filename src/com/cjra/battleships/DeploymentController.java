package com.cjra.battleships;

public class DeploymentController {
    private final DeploymentView view;
    private final DeploymentModel model;

    public DeploymentController(DeploymentView view, DeploymentModel model){
        this.view = view;
        this.model = model;
    }

    public void resetGrid() {
        model.reset();
        updateView();
    }

    public void selectCell(int x, int y) {
        model.pickCell(x, y);
        updateView();
    }

    private void updateView() {
        view.displayGrid(model.getGrid());
        view.offerShipPlacement(model.getShipOffer());
    }
}
