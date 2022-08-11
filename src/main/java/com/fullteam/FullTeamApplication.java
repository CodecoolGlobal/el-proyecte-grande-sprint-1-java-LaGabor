package com.fullteam;

import com.fullteam.model.Game;
import com.fullteam.model.GameType;
import com.fullteam.model.Profile;
import com.fullteam.model.Team;
import com.fullteam.service.GameCreator;
import com.fullteam.service.ProfileCreator;
import com.fullteam.service.TeamCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class FullTeamApplication {

	public static void main(String[] args) {
		SpringApplication.run(FullTeamApplication.class, args);
		TeamCreator teamCreator = new TeamCreator();

		ProfileCreator profileCreator = new ProfileCreator();

		GameCreator gameCreator = new GameCreator();

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
		Set boardGames = Stream.of(mars,monopoly,risk,cascadia).collect(Collectors.toSet());
		Set onlineGames = Stream.of(marsOnline,diplomacy,dominion).collect(Collectors.toSet());
		Profile ducky = profileCreator.createProfile("Ducktor. Quackery Quack",LocalDate.of(2018,1,13),"I like bread and fish quack.",boardGames,onlineGames);
		Team duckTales = teamCreator.createTeam("Duck Tales","Team for ducks who wears T-shirt BUT NO PANTS!",(byte)5,(byte)2,(byte)4,dominion,ducky);
		Team wingsOfFreedom = teamCreator.createTeam("Wings of freedom","Fear our feathers.",(byte)5,(byte)2,(byte)4,dAndD,ducky);
	}




}
