package com.fullteam.service;

import com.fullteam.model.Profile;
import com.fullteam.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProfileService {
    private final ProfileRepository profileRepository;




    @Autowired
    public ProfileService(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;

    }

    public void addProfile(Profile profile) {
        profileRepository.save(profile);
    }

    public Optional<Profile> getProfile(Long id) {
        return profileRepository.findById(id);
    }

}
