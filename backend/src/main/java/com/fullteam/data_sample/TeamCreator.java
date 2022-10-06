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
        List<Profile> profiles = profileCreator.getProfiles();
        List<Game> games = gameCreator.getGames();
        teamService.addTeam(Team.builder()
                .teamName("Duck Tales")
                .teamDescription("Team for ducks who wears T-shirt BUT NO PANTS!")
                .maxWantedTeamSize((byte)5)
                .minWantedTeamSize((byte)2)
                .freePlaces((byte)4)
                .admin(profiles.get(0))
                .players(List.of(profiles.get(0)))
                .game(games.get(5))
                .build());

        teamService.addTeam(Team.builder()
                .teamName("Dagobers")
                .teamDescription("Own the lake own the world")
                .maxWantedTeamSize((byte)5)
                .minWantedTeamSize((byte)3)
                .freePlaces((byte)4)
                .admin(profiles.get(3))
                .players(List.of(profiles.get(3)))
                .game(games.get(1))
                .build());

        teamService.addTeam(Team.builder()
                .teamName("Naturals")
                .teamDescription("Yeah we are just simple ducks in the nature .... boring!")
                .maxWantedTeamSize((byte)4)
                .minWantedTeamSize((byte)4)
                .freePlaces((byte)3)
                .admin(profiles.get(2))
                .players(List.of(profiles.get(2)))
                .game(games.get(3))
                .build());

        teamService.addTeam(Team.builder()
                .teamName("Elon Ducks")
                .teamDescription("DuckCoin to the Mars!")
                .maxWantedTeamSize((byte)5)
                .minWantedTeamSize((byte)3)
                .freePlaces((byte)4)
                .admin(profiles.get(2))
                .players(List.of(profiles.get(2)))
                .game(games.get(4))
                .build());

        teamService.addTeam(Team.builder()
                .teamName("Ducktators")
                .teamDescription("Fly upward not downward!")
                .maxWantedTeamSize((byte)6)
                .minWantedTeamSize((byte)4)
                .freePlaces((byte)5)
                .admin(profiles.get(1))
                .players(List.of(profiles.get(1)))
                .game(games.get(6))
                .build());


        teamService.addTeam(Team.builder()
                .teamName("Wings of freedom")
                .teamDescription("Fear our feathers.")
                .maxWantedTeamSize((byte)5)
                .minWantedTeamSize((byte)2)
                .freePlaces((byte)4)
                .players(List.of(profiles.get(1)))
                .admin(profiles.get(1))
                .game(games.get(2))
                .build());

        teamService.addTeam(Team.builder()
                .teamName("Bread Seekers")
                .teamDescription("Peck for glory ... and dry breadcrumbs.")
                .maxWantedTeamSize((byte)8)
                .minWantedTeamSize((byte)6)
                .freePlaces((byte)7)
                .players(List.of(profiles.get(1)))
                .admin(profiles.get(1))
                .game(games.get(7))
                .build());

        teamService.addTeam(Team.builder()
                .teamName("Wingzard")
                .teamDescription("D&D addict ducks.")
                .maxWantedTeamSize((byte)8)
                .minWantedTeamSize((byte)6)
                .freePlaces((byte)7)
                .players(List.of(profiles.get(2)))
                .admin(profiles.get(2))
                .game(games.get(8))
                .build());

        teamService.addTeam(Team.builder()
                .teamName("Harry Duckter")
                .teamDescription("Harry you are a Duck!")
                .maxWantedTeamSize((byte)4)
                .minWantedTeamSize((byte)2)
                .freePlaces((byte)3)
                .players(List.of(profiles.get(0)))
                .admin(profiles.get(0))
                .game(games.get(9))
                .build());

    }


}
