package com.fullteam.data_sample;

import com.fullteam.model.Game;
import com.fullteam.model.Profile;
import com.fullteam.security.UserRole;
import com.fullteam.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Component
public class ProfileCreator {

    private final ProfileService profileService;
    private final GameCreator gameCreator;
    private final PasswordEncoder passwordEncoder;
    private Profile profile;


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
                        .build();
        profileService.addProfile(profile1);

        profile=profile1;
    }

    public Profile getProfile() {
        return profile;
    }
}
