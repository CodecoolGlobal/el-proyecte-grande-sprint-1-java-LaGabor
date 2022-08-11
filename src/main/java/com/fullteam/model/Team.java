package com.fullteam.model;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Team {
    private final String teamName;
    private String teamDescription;
    private final byte maxWantedTeamSize;
    private final byte minWantedTeamSize;
    private byte freePlaces;
    private Game playedGame;
    private final LocalDate teamCreated=LocalDate.now();
    private final int id;
    private final Profile admin;
    private List<Profile> players = new ArrayList<>();

    public Team(String teamName, String teamDescription, byte maxWantedTeamSize,byte minWantedTeamSize, byte freePlaces, Game playedGame,int id,Profile admin) {
        this.teamName = teamName;
        this.teamDescription = teamDescription;
        this.maxWantedTeamSize = maxWantedTeamSize;
        this.minWantedTeamSize = minWantedTeamSize;
        this.freePlaces = freePlaces;
        this.playedGame = playedGame;
        this.id = id;
        this.admin = admin;
        players.add(admin);

    }


}
