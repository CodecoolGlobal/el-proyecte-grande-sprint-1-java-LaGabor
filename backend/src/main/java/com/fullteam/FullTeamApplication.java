package com.fullteam;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.fullteam.service.GameService;
import com.fullteam.service.ProfileService;
import com.fullteam.service.TeamService;
import com.fullteam.model.Game;
import com.fullteam.model.types.GameType;
import com.fullteam.model.Profile;
import com.fullteam.model.Team;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FullTeamApplication implements CommandLineRunner {
    private TeamService teamService;
    private GameService gameService;
    private ProfileService profileService;

    @Autowired
    public FullTeamApplication(TeamService teamService, GameService gameService, ProfileService profileService) {
        this.teamService = teamService;
        this.gameService = gameService;
        this.profileService = profileService;
    }

    public static void main(String[] args) {
        SpringApplication.run(FullTeamApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

    }

    private Game getRandomElementFromSet(Set<Game> set) {
        int randomIndex = (int) (Math.random() * set.size());
        return set.stream().skip(randomIndex).findFirst().get();
    }
}
