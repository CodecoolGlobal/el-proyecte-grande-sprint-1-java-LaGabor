package com.fullteam.data_sample;

import com.fullteam.model.Team;
import com.fullteam.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TeamCreator {

    private final TeamService teamService;

    @Autowired
    public TeamCreator(TeamService teamService) {
        this.teamService = teamService;
        initialize();
    }

    public void initialize(){
        teamService.addTeam(Team.builder()
                .teamName("Duck Tales")
                .teamDescription("Team for ducks who wears T-shirt BUT NO PANTS!")
                .maxWantedTeamSize((byte)5)
                .minWantedTeamSize((byte)2)
                .freePlaces((byte)4)
                .build());
        teamService.addTeam(Team.builder()
                .teamName("Wings of freedom")
                .teamDescription("Fear our feathers.")
                .maxWantedTeamSize((byte)5)
                .minWantedTeamSize((byte)2)
                .freePlaces((byte)4)
                .build());
    }
}
