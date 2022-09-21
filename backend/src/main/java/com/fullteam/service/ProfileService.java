package com.fullteam.service;

import com.fullteam.model.Profile;
import com.fullteam.repository.ProfileRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Slf4j
public class ProfileService implements UserDetailsService {
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

    public List<Profile> getProfiles(){
        return profileRepository.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Profile profile = profileRepository.findByUsername(username);
        if(profile == null) {
            log.error("No user in database with: {}", username);
            throw new UsernameNotFoundException("User not found in database");
        }else {
            log.info("{} user found in database", username);
        }
        Collection<SimpleGrantedAuthority> authorizes = new ArrayList<>();
        Collections.singletonList(profile.getRoles())
                .forEach(role ->
                        authorizes.add(new SimpleGrantedAuthority(role.name())));

        return new User(profile.getUsername(), profile.getPassword(), authorizes);
    }
}
