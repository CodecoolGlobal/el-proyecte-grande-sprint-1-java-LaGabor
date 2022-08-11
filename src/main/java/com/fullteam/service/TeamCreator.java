package com.fullteam.service;

import com.fullteam.model.Game;
import com.fullteam.model.Profile;
import com.fullteam.model.Team;
import org.springframework.stereotype.Service;

@Service
public class TeamCreator {

    private static int id = 1;

    public Team createTeam(String teamName, String teamDescription, byte maxWantedTeamSize,byte minWantedTeamSize, byte freePlaces, Game playedGame, Profile admin) {
        return new Team(teamName,teamDescription,maxWantedTeamSize,minWantedTeamSize,freePlaces,playedGame,id++,admin);
    }
}
