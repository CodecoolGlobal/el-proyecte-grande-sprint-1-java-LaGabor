package com.fullteam;

import java.time.LocalDate;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.fullteam.dao.TeamDao;
import com.fullteam.model.Game;
import com.fullteam.model.GameType;
import com.fullteam.model.Profile;
import com.fullteam.model.Team;
import com.fullteam.service.GameCreator;
import com.fullteam.service.ProfileCreator;
import com.fullteam.service.TeamCreator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FullTeamApplication implements CommandLineRunner {
    private TeamCreator teamCreator;
    private TeamDao teamDao;

    private ProfileCreator profileCreator;

    private GameCreator gameCreator;

    @Autowired
    public FullTeamApplication(TeamCreator teamCreator, ProfileCreator profileCreator, GameCreator gameCreator, TeamDao teamDao) {
        this.teamCreator = teamCreator;
        this.profileCreator = profileCreator;
        this.gameCreator = gameCreator;
        this.teamDao = teamDao;
    }

    public static void main(String[] args) {
        SpringApplication.run(FullTeamApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // TODO Auto-generated method stub
        Game mars = gameCreator.creatGame("Mars",(byte)1,(byte)5, GameType.BOARD,"Ducks taking over the Mars!");
        Game monopoly = gameCreator.creatGame("Monopoly",(byte)2,(byte)5, GameType.BOARD,"Ducks taking over the capitalism!");
        Game risk = gameCreator.creatGame("Risk",(byte)2,(byte)6, GameType.BOARD,"Ducks fighting for land!");
        Game cascadia = gameCreator.creatGame("Cascadia",(byte)1,(byte)4, GameType.BOARD,"Ducks in the Nature!(Fiction)");
        Game marsOnline = gameCreator.creatGame("Mars",(byte)1,(byte)5, GameType.ONLINE,"Ducks taking over the Mars now Online!");
        Game diplomacy = gameCreator.creatGame("Diplomacy",(byte)2,(byte)7, GameType.ONLINE,"Vote for the Duck Party! More bread less hunter!");
        Game dominion = gameCreator.creatGame("Dominion",(byte)2,(byte)6, GameType.ONLINE,"Make your dUcktopia!");
        Game pathFinder = gameCreator.creatGame("PathFinder",(byte)2,(byte)8, GameType.RPG,"Game for cool Ducks!");
        Game dAndD = gameCreator.creatGame("Dungeons and Ducks",(byte)2,(byte)8, GameType.RPG,"Game for the coolest Ducks!");
        Game magic = gameCreator.creatGame("Magic",(byte)2,(byte)4, GameType.RPG,"Card game for Ducks (with thumb)!");
        Set<Game> boardGames = Stream.of(mars,monopoly,risk,cascadia).collect(Collectors.toSet());
        Set<Game> onlineGames = Stream.of(marsOnline,diplomacy,dominion).collect(Collectors.toSet());
        Profile ducky = profileCreator.createProfile("Ducktor. Quackery Quack",LocalDate.of(2018,1,13),"I like bread and fish quack.",boardGames,onlineGames);
        Team duckTales = teamCreator.createTeam("Duck Tales","Team for ducks who wears T-shirt BUT NO PANTS!",(byte)5,(byte)2,(byte)4,dominion,ducky);
        Team wingsOfFreedom = teamCreator.createTeam("Wings of freedom","Fear our feathers.",(byte)5,(byte)2,(byte)4,dAndD,ducky);
        teamDao.addTeam(duckTales);
        teamDao.addTeam(wingsOfFreedom);
    }
}
