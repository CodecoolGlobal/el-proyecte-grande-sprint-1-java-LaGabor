package com.fullteam;

import com.fullteam.model.Game;
import com.fullteam.model.Profile;
import com.fullteam.service.GameCreator;
import com.fullteam.service.ProfileCreator;
import com.fullteam.service.TeamCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.Set;

@SpringBootApplication
public class FullTeamApplication {

	@Autowired
	private static TeamCreator teamCreator;

	@Autowired
	private static ProfileCreator profileCreator;

	@Autowired
	private static GameCreator gameCreator;

	public static void main(String[] args) {
		SpringApplication.run(FullTeamApplication.class, args);

	}




}
