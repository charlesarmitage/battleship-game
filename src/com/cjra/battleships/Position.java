package com.cjra.battleships;

public class Position {
    public final int x;
    public final int y;

    public Position(int x, int y){
        this.x = x;
        this.y = y;
    }

    public boolean matches(int x, int y){
        return this.x == x && this.y == y;
    }

    public boolean matches(Position position) {
        return this.matches(position.x, position.y);
    }
}

