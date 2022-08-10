package com.fullteam.service;

import com.fullteam.model.Game;
import com.fullteam.model.Profile;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Set;

@Service
public class ProfileCreator {


    public Profile createProfile(String name, LocalDateTime birthDate, String profileDescription, Set<Game> ownedBoardGames, Set<Game> ownedComputerGames) {

        return null;
    }
}
