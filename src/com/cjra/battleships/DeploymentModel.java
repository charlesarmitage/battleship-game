package com.cjra.battleships;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class DeploymentModel {
    private Selection selection = new Selection();
    private List<ShipType> availableShips = new ArrayList<ShipType>();

    public DeploymentModel(){
        availableShips.add(ShipType.PATROL_BOAT);
        availableShips.add(ShipType.DESTROYER);
        availableShips.add(ShipType.BATTLESHIP);
        availableShips.add(ShipType.AIRCRAFT_CARRIER);
    }

    public void reset() {
        selection = new Selection();
    }

    public CellType[][] getGrid() {
        CellType[][] currentGrid = buildGrid();
        for(Position position : selection.getPositions()){
            currentGrid[position.x][position.y] = CellType.SELECTED;
        }
        return currentGrid;
    }

    public void pickCell(int x, int y){

        if(!selection.isSelected(x, y)) {
            selection.select(x, y);
        }
        else {
            selection.clear(x, y);
        }
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
        }
    }

    public Collection<ShipType> getAvailableShips() {
        return Collections.unmodifiableCollection(availableShips);
    }

    private CellType[][] buildGrid() {
        CellType[][] grid = new CellType[10][10];
        for(int x = 0; x < 10; x++){
            for(int y = 0; y < 10; y++){
                grid[x][y] = CellType.EMPTY;
            }
        }
        return grid;
    }
}
