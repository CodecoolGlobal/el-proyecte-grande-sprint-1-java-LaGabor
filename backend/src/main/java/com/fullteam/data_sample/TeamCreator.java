package com.fullteam.data_sample;

import com.fullteam.model.Game;
import com.fullteam.model.Profile;
import com.fullteam.model.Team;
import com.fullteam.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TeamCreator {

    private final TeamService teamService;
    private final ProfileCreator profileCreator;
    private final GameCreator gameCreator;
    @Autowired
    public TeamCreator(TeamService teamService, ProfileCreator profileCreator, GameCreator gameCreator) {
        this.teamService = teamService;
        this.profileCreator = profileCreator;
        this.gameCreator = gameCreator;
        initialize();
    }

    public void initialize(){
        Profile profile = profileCreator.getProfile();
        List<Game> games = gameCreator.getGames();
        teamService.addTeam(Team.builder()
                .teamName("Duck Tales")
                .teamDescription("Team for ducks who wears T-shirt BUT NO PANTS!")
                .maxWantedTeamSize((byte)5)
                .minWantedTeamSize((byte)2)
                .freePlaces((byte)4)
                .admin(profile)
                .players(List.of(profile))
                .game(games.get(5))
                .build());

        teamService.addTeam(Team.builder()
                .teamName("Wings of freedom")
                .teamDescription("Fear our feathers.")
                .maxWantedTeamSize((byte)5)
                .minWantedTeamSize((byte)2)
                .freePlaces((byte)4)
                .players(List.of(profile))
                .admin(profile)
                .game(games.get(2))
                .build());
    }
}
