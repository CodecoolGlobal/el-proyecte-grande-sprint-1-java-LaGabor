package com.fullteam.model.types;

public enum GameType {
    BOARD,
    ONLINE,
    RPG;

    @Override
    public String toString() {
        return name();
    }
}
