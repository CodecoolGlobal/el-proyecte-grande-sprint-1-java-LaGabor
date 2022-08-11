package com.fullteam.service;

import com.fullteam.model.Game;
import com.fullteam.model.Profile;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.Set;

@Service
public class ProfileCreator {

    private static int id = 1;

    public Profile createProfile(String name, LocalDate birthDate, String profileDescription, Set<Game> ownedBoardGames, Set<Game> ownedComputerGames) {

        return new Profile(name,birthDate,profileDescription,ownedBoardGames,ownedComputerGames,id++);
    }
}
