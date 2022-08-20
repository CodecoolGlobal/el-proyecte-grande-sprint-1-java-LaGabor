package com.fullteam.controller.dto;

import com.fullteam.model.types.GameType;


public class GameDto {
    private String title;
    private GameType gameType = GameType.ONLINE;
    private byte minPlayer;
    private byte maxPlayer;
    private String description;

    public String getTitle() {
        return title;
    }

    public byte getMinPlayer() {
        return minPlayer;
    }

    public byte getMaxPlayer() {
        return maxPlayer;
    }

    public GameType getGameType() {
        return gameType;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "GameDto{" +
                "title='" + title + '\'' +
                ", minPlayer=" + minPlayer +
                ", maxPlayer=" + maxPlayer +
                ", gameType=" + gameType +
                ", description='" + description + '\'' +
                '}';
    }
}
