package com.fullteam.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class Team {
    @Builder.Default
    private String teamName = "Annonymous";
    @Builder.Default
    private String teamDescription = "No description added yet.";
    private final byte maxWantedTeamSize;
    private final byte minWantedTeamSize;
    private byte freePlaces;
    @Builder.Default
    private Game game = null;
    private final int id;
    @Builder.Default
    private Profile admin = null;
    private final LocalDate teamCreated = LocalDate.now();
    @Builder.Default
    private List<Profile> players = new ArrayList<>();

    public Team(String teamName, String teamDescription, byte maxWantedTeamSize, byte minWantedTeamSize, byte freePlaces, Game game, int id, Profile admin, List<Profile> players) {
            this.teamName = teamName;
            this.teamDescription = teamDescription;
            this.maxWantedTeamSize = maxWantedTeamSize;
            this.minWantedTeamSize = minWantedTeamSize;
            this.freePlaces = freePlaces;
            this.game = game;
            this.id = id;
            this.admin = admin;
            this.players = players;
            players.add(admin);
    }

    public int getId() {
        return id;
    }

    public void setAdmin(Profile admin) {
        if (this.admin == null) {
            this.admin = admin;
            this.players.set(this.players.indexOf(null), this.admin);
        }
        else {
            throw new IllegalArgumentException("Team is already have a team leader");
        }
    }

    public void setGame(Game game) {
        if (this.game == null) {
            this.game = game;
        }
        else {
            throw new IllegalArgumentException("Team is already have a game");
        }
    }


}
