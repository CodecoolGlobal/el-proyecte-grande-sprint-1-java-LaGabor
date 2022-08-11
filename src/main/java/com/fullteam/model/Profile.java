package com.fullteam.model;


import java.time.LocalDate;
import java.util.Set;

public class Profile {

    private final String name;
    private final LocalDate birthDate;
    private final LocalDate registrationDate = LocalDate.now();
    private  String profileDescription;
    private Set<Game> ownedComputerGames;
    private Set<Game> ownedBoardGames;
    private final int id;


    public Profile(String name, LocalDate birthDate, String profileDescription, Set<Game> ownedComputerGames, Set<Game> ownedBoardGames,int id) {
        this.name = name;
        this.birthDate = birthDate;
        this.profileDescription = profileDescription;
        this.ownedComputerGames = ownedComputerGames;
        this.ownedBoardGames = ownedBoardGames;
        this.id = id;

    }
}
