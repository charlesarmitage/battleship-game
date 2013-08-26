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

    private void addAllAvailableShips() {
        availableShips.add(ShipType.PATROL_BOAT);
        availableShips.add(ShipType.DESTROYER);
        availableShips.add(ShipType.BATTLESHIP);
        availableShips.add(ShipType.AIRCRAFT_CARRIER);
    }

    public void reset() {
        selection = new Selection();
        deployedShips = new ArrayList<Ship>();
        availableShips = new ArrayList<ShipType>();
        addAllAvailableShips();
    }

    public void pickCell(int x, int y){

        if(!selection.isSelected(x, y)) {
            if(selection.shortEnough(availableShips)){
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
        for(Ship ship : deployedShips){
            for(Position shipPosition : ship.getPositions()){
                if(shipPosition.matches(position.x, position.y)){
                    return false;
                }
            }
        }
        return true;
    }

    public ShipType getShipOffer() {

        ShipType type = ShipType.NONE;

        switch(selection.size())
        {
            case 2:
                type = ShipType.PATROL_BOAT;
                break;
            case 3:
                type = ShipType.DESTROYER;
                break;
            case 4:
                type = ShipType.BATTLESHIP;
                break;
            case 5:
                type = ShipType.AIRCRAFT_CARRIER;
                break;
            default:
                break;
        }

        return type;
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

    public boolean AllShipsPlaced() {
        return !availableShips.isEmpty();
    }
}
