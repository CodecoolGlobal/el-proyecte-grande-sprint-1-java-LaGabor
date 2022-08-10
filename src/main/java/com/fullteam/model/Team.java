package com.fullteam.model;


import java.time.LocalDate;

public class Team {
    private final String teamName;
    private String teamDescription;
    private byte wantedTeamSize;
    private byte freePlaces;
    private Game playedGame;
    private final LocalDate teamCreated=LocalDate.now();

    public Team(String teamName, String teamDescription, byte wantedTeamSize, byte freePlaces, Game playedGame) {
        this.teamName = teamName;
        this.teamDescription = teamDescription;
        this.wantedTeamSize = wantedTeamSize;
        this.freePlaces = freePlaces;
        this.playedGame = playedGame;
    }


}
