package com.fullteam.service;

import com.fullteam.controller.dto.LoginDto;
import com.fullteam.controller.dto.RegistrationProfileDto;
import com.fullteam.model.Profile;
import com.fullteam.repository.ProfileRepository;
import com.fullteam.security.UserRole;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Slf4j
public class ProfileService implements UserDetailsService {
    private final ProfileRepository profileRepository;
    private PasswordEncoder passwordEncoder;



    @Autowired
    public ProfileService(ProfileRepository profileRepository, PasswordEncoder passwordEncoder) {
        this.profileRepository = profileRepository;
        this.passwordEncoder = passwordEncoder;


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


    public  boolean checkProfileNameExistence(String profileName){
        Optional<Profile> profile = profileRepository.findByUsername(profileName);
        if(profile.isEmpty()){
            return false;
        }
        return true;
    }

    public boolean checkEmailExistence(String email){
        Optional<Profile> profile = profileRepository.findByEmail(email);
        if(profile.isEmpty()){
            return false;
        }
        return true;
    }

    public Profile saveProfileFromDto(RegistrationProfileDto profileDto){
        Profile profile = Profile.builder()
                .username(profileDto.getUsername())
                .email(profileDto.getEmail())
                .roles(UserRole.USER)
                .birthDate(profileDto.getBirthDate())
                .password(passwordEncoder.encode(profileDto.getPassword()))
                .build();
        return save(profile);
    }


    public Profile save(Profile profile) {
        return profileRepository.save(profile);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Profile profile;
        Optional<Profile> optionalProfile = profileRepository.findByUsername(username);
        if(optionalProfile.isEmpty()) {
            log.error("No user in database with: {}", username);
            throw new UsernameNotFoundException("User not found in database");
        }else {
            log.info("{} user found in database", username);
            profile = optionalProfile.get();
        }
        Collection<SimpleGrantedAuthority> authorizes = new ArrayList<>();
        Collections.singletonList(profile.getRoles())
                .forEach(role ->
                        authorizes.add(new SimpleGrantedAuthority(role.name())));

        return new User(profile.getUsername(), profile.getPassword(), authorizes);
    }

    public void profileLogin(LoginDto loginDto) {

    }
}
