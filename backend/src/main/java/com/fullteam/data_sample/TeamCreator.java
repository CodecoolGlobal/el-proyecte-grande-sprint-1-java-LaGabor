package com.fullteam.data_sample;

import com.fullteam.model.Team;
import com.fullteam.service.dao.TeamMemory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TeamCreator {

    TeamMemory teamMemory;

    @Autowired
    public TeamCreator(TeamMemory teamMemory) {
        this.teamMemory = teamMemory;
        initialize();
    }

    public void initialize(){
        teamMemory.addTeam(Team.builder()
                .id(0)
                .teamName("Duck Tales")
                .teamDescription("Team for ducks who wears T-shirt BUT NO PANTS!")
                .maxWantedTeamSize((byte)5)
                .minWantedTeamSize((byte)2)
                .freePlaces((byte)4)
                .build());
        teamMemory.addTeam(Team.builder()
                .id(1)
                .teamName("Wings of freedom")
                .teamDescription("Fear our feathers.")
                .maxWantedTeamSize((byte)5)
                .minWantedTeamSize((byte)2)
                .freePlaces((byte)4)
                .build());
    }
}
