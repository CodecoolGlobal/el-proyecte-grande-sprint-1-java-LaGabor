package com.fullteam.model.types;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum GameType {
    BOARD,
    ONLINE,
    RPG;

    @Override
    public String toString() {
        return name();
    }

    @JsonCreator
    public static GameType SaveType(String value){
        return GameType.valueOf(value);
    }
}
