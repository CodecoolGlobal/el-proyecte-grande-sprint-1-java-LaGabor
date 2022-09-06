package com.fullteam.data_sample;

import com.fullteam.model.Profile;
import com.fullteam.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.time.LocalDate;

@Component
public class ProfileCreator {

    private final ProfileService profileService;



    @Autowired
    public ProfileCreator(ProfileService profileService) {
        this.profileService = profileService;
    }

    private void initialize() {
        profileService.addProfile(
                Profile.builder()
                        .name("Ducktor Quackery Quack")
                        .birthDate(LocalDate.of(2018,1,13))
                        .description("I like bread and fish quack.")
                        .build()
        );}

}
