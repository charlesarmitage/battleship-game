package com.cjra.battleships;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class DeploymentModel {
    private Selection selection = new Selection();
    private List<ShipType> availableShips = new ArrayList<ShipType>();
    private List<Ship> deployedShips = new ArrayList<Ship>();

    public DeploymentModel(){
        addAllAvailableShips();
    }

    public void reset() {
        selection = new Selection();
        deployedShips = new ArrayList<Ship>();
        availableShips = new ArrayList<ShipType>();
        addAllAvailableShips();
    }

    public void pickCell(int x, int y){

        if(!selection.isSelected(x, y)) {
            if(selection.isShortEnough(availableShips)){
                if(isEmpty(new Position(x,y))){
                    selection.select(x, y);
                }
            }
        }
        else {
            selection.clear(x, y);
        }
    }

    private boolean isEmpty(Position position) {
        CellPlacer placer = new CellPlacer(deployedShips);
        return placer.isAvailable(position) && placer.isInBounds(position.x, position.y);
    }

    public ShipType getShipOffer() {
        return ShipDetails.getShipForLength(selection.size());
    }

    public void placeShip(ShipType ship) {

        if(getShipOffer() == ship){
            availableShips.remove(ship);
            deployedShips.add(ShipBuilder.buildShip(ship, selection));
            selection = new Selection();
        }
    }

    public List<Position> getSelection() {
        return selection.getPositions();
    }

    public Collection<ShipType> getAvailableShips() {
        return Collections.unmodifiableCollection(availableShips);
    }

    public Collection<Ship> getDeployedShips() {
        return deployedShips;
    }

    public boolean allShipsPlaced() {
        return !availableShips.isEmpty();
    }

    private void addAllAvailableShips() {
        availableShips.add(ShipType.PATROL_BOAT);
        availableShips.add(ShipType.DESTROYER);
        availableShips.add(ShipType.BATTLESHIP);
        availableShips.add(ShipType.AIRCRAFT_CARRIER);
    }
}
