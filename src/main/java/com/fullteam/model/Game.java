package com.fullteam.model;

public class Game {
    private final String  title;
    private final  byte  minPlayer;
    private final  byte  maxPlayer;
    private final  GameType gameType;
    private final String description;
    private final int id;

    public Game(String title, byte minPlayer, byte maxPlayer, GameType gameType,String description,int id) {
        this.title = title;
        this.minPlayer = minPlayer;
        this.maxPlayer = maxPlayer;
        this.gameType = gameType;
        this.description = description;
        this.id = id;
    }
}
