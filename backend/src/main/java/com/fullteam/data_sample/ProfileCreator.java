package com.fullteam.data_sample;

import com.fullteam.model.Game;
import com.fullteam.model.Profile;
import com.fullteam.security.UserRole;
import com.fullteam.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Component
public class ProfileCreator {

    private final ProfileService profileService;
    private final GameCreator gameCreator;
    private final PasswordEncoder passwordEncoder;
    private List<Profile> profiles = new ArrayList<>();


    @Autowired
    public ProfileCreator(ProfileService profileService, GameCreator gameCreator, PasswordEncoder passwordEncoder) {
        this.profileService = profileService;
        this.gameCreator = gameCreator;
        this.passwordEncoder = passwordEncoder;
        initialize();
    }

    private void initialize() {

        List<Game> games = gameCreator.getGames();

        Profile profile1 =
                Profile.builder()
                        .username("Ducktor Quackery Quack")
                        .birthDate(LocalDate.of(2018,1,13))
                        .description("I like bread and fish quack.")
                        .ownedBoardGames(Set.of(games.get(0),games.get(1)))
                        .ownedOnlineGames(Set.of(games.get(6),games.get(7)))
                        .roles(UserRole.USER)
                        .password(passwordEncoder.encode("kacsakacsa"))
                        .email("ducktheball@quackmail.duck")
                        .build();

        Profile profile2 =
                Profile.builder()
                        .username("Pig Eon")
                        .birthDate(LocalDate.of(2010,6,22))
                        .description("Oink!")
                        .ownedBoardGames(Set.of(games.get(0),games.get(1)))
                        .ownedOnlineGames(Set.of(games.get(6),games.get(7)))
                        .roles(UserRole.USER)
                        .password(passwordEncoder.encode("pigpig"))
                        .email("pigeon@pigeon.com")
                        .build();

        Profile profile3 =
                Profile.builder()
                        .username("Hen Tess")
                        .birthDate(LocalDate.of(2014,5,2))
                        .description("I dont like meat.")
                        .ownedBoardGames(Set.of(games.get(0),games.get(1)))
                        .ownedOnlineGames(Set.of(games.get(6),games.get(7)))
                        .roles(UserRole.USER)
                        .password(passwordEncoder.encode("henhen"))
                        .email("hentes@hen.com")
                        .build();

        Profile profile4 =
                Profile.builder()
                        .username("Psy Duck")
                        .birthDate(LocalDate.of(1996,2,27))
                        .description("My head is hurting.")
                        .ownedBoardGames(Set.of(games.get(0),games.get(1)))
                        .ownedOnlineGames(Set.of(games.get(6),games.get(7)))
                        .roles(UserRole.ADMIN)
                        .password(passwordEncoder.encode("pocketmonster"))
                        .email("pocke@mon.com")
                        .build();

        profiles.addAll(List.of(profile1,profile2,profile3,profile4));
        profileService.addAllProfile(profiles);

    }

    public List<Profile> getProfiles() {
        return profiles;
    }
}
