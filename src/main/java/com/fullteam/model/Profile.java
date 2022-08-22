package com.fullteam.model;


import com.fullteam.model.types.GameType;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Data
@Builder
public class Profile {

    private final String name;
    private final LocalDate birthDate;
    private final LocalDate registrationDate = LocalDate.now();
    @Builder.Default
    private  String description = "No description added yet.";
    @Builder.Default
    private Set<Game> ownedOnlineGames = new HashSet<>();
    @Builder.Default
    private Set<Game> ownedBoardGames = new HashSet<>();
    private final int id;


    public Profile(String name, LocalDate birthDate, String description, Set<Game> ownedOnlineGames, Set<Game> ownedBoardGames, int id) {
        this.name = name;
        this.birthDate = birthDate;
        this.description = description;
        this.ownedOnlineGames = ownedOnlineGames;
        this.ownedBoardGames = ownedBoardGames;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void addToOnlineGameList(Game game) {
        if (game.getType() == GameType.ONLINE) {
            ownedOnlineGames.add(game);
        }
        else {
            throw new IllegalArgumentException("Game is not a computer game");
        }
    }

    public void addToBoardGameList(Game game) {
        if (game.getType() == GameType.BOARD) {
            ownedBoardGames.add(game);
        }
        else {
            throw new IllegalArgumentException("Game is not a board game");
        }
    }

}
