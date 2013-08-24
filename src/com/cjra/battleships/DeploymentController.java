package com.cjra.battleships;

import java.util.ArrayList;
import java.util.List;

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

    public void placeShip(ShipType ship) {
        model.placeShip(ship);
        updateView();
    }

    private void updateView() {
        view.displayGrid(model.getGrid(), model.getDeployedShips());
        view.offerShipPlacement(model.getShipOffer());
        view.displayAvailableShips(model.getAvailableShips());
    }
}
