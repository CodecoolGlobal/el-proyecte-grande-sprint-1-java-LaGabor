package com.fullteam.service;

import com.fullteam.model.Game;
import com.fullteam.model.Team;
import org.springframework.stereotype.Service;

@Service
public class TeamCreator {

    private static int id = 1;

    public Team createTeam(String teamName, String teamDescription, byte wantedTeamSize, byte freePlaces, Game playedGame) {
        return new Team(teamName,teamDescription,wantedTeamSize,freePlaces,playedGame,id++);
    }
}
