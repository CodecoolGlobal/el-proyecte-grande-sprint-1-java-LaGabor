package com.fullteam.data_sample;

import com.fullteam.model.Profile;
import com.fullteam.service.dao.ProfileMemory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.time.LocalDate;

@Component
public class ProfileCreator {

    ProfileMemory profileMemory;

    @Autowired
    public ProfileCreator(ProfileMemory profileMemory) {
        this.profileMemory = profileMemory;
        initialize();
    }

    private void initialize() {
        profileMemory.addProfile(
                Profile.builder()
                        .id(0)
                        .name("Ducktor Quackery Quack")
                        .birthDate(LocalDate.of(2018,1,13))
                        .description("I like bread and fish quack.")
                        .build()
        );}

}