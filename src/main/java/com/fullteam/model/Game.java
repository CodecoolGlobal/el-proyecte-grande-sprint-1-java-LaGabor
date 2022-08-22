package com.fullteam.model;


import com.fullteam.model.types.GameType;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class Game {
    private final String title;
    @Builder.Default
    private byte minPlayer = 2;
    @Builder.Default
    private byte maxPlayer = 4;
    private final GameType type;
    @Builder.Default
    private String description = "No description added yet.";
    private final int id;

    public Game(String title, byte minPlayer, byte maxPlayer, GameType gameType,String description,int id) {
        this.title = title;
        this.minPlayer = minPlayer;
        this.maxPlayer = maxPlayer;
        this.type = gameType;
        this.description = description;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public GameType getType() {
        return type;
    }
}
