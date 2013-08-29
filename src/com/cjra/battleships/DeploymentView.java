package com.cjra.battleships;

import java.util.Collection;
import java.util.List;

public interface DeploymentView {

    public void displaySelection(Positionable selection);
    public void displayShips(Collection<? extends Positionable> deployedShips);
    public void displayAvailableShips(Collection<ShipType> availableShips);

    public void offerShipPlacement(ShipType ship);
    public void offerGameStart();

    public void refreshView();
}
