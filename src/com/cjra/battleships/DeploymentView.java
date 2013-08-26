package com.cjra.battleships;

import java.util.Collection;
import java.util.List;

public interface DeploymentView {

    public void displaySelection(List<Position> selection);
    public void displayShips(Collection<Ship> deployedShips);
    public void displayAvailableShips(Collection<ShipType> availableShips);

    public void offerShipPlacement(ShipType ship);
    public void offerGameStart();
}
