package com.fullteam.model;

public class Game {
    private final String  title;
    private final  byte  minPlayer;
    private final  byte  maxPlayer;
    private final  GameType gameType;

    public Game(String title, byte minPlayer, byte maxPlayer, GameType gameType) {
        this.title = title;
        this.minPlayer = minPlayer;
        this.maxPlayer = maxPlayer;
        this.gameType = gameType;
    }
}
