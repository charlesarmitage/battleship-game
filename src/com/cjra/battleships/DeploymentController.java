package com.cjra.battleships;

public class DeploymentController implements ShipDeployment {
    private final DeploymentView view;
    private final DeploymentModel model;

    public DeploymentController(DeploymentView view, DeploymentModel model){
        this.view = view;
        this.model = model;
    }

    @Override
    public void refresh() {

    }

    @Override
    public void resetGrid() {
        model.reset();
        updateView();
    }

    @Override
    public void selectCell(int x, int y) {
        model.pickCell(x, y);
        updateView();
    }

    @Override
    public void placeShip(ShipType ship) {
        model.placeShip(ship);
        updateView();
        if(model.allShipsPlaced()){
            view.offerGameStart();
        }
    }

    private void updateView() {
        view.displayShips(model.getDeployedShips());
        view.displaySelection(model.getSelection());
        view.offerShipPlacement(model.getShipOffer());
        view.displayAvailableShips(model.getAvailableShips());
        view.refreshView();
    }
}
