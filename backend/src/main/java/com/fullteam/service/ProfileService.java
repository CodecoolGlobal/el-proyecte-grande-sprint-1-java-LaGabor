package com.fullteam.service;

import com.fullteam.controller.dto.LoginDto;
import com.fullteam.controller.dto.RegistrationProfileDto;
import com.fullteam.model.Game;
import com.fullteam.model.Profile;
import com.fullteam.repository.ProfileRepository;
import com.fullteam.security.UserRole;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    public void addAllProfile(List<Profile> profiles){
        for(Profile profile: profiles){
            profileRepository.save(profile);
        }
    }

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

    public Optional<Profile> getProfileByEmail(String email) {
        return profileRepository.findByEmail(email);
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

    public ResponseEntity<String> profileLogin(LoginDto loginDto) {
        Optional<Profile> profileOptional = getProfileByEmail(loginDto.getEmail());
        if(profileOptional.isPresent()){
            if(passwordEncoder.matches(loginDto.getPassword(),profileOptional.get().getPassword())){
                return new ResponseEntity<>("Successful Login!", HttpStatus.OK);
            }
            return new ResponseEntity<>("Email or  password error!", HttpStatus.UNAUTHORIZED);
        }
        return new ResponseEntity<>("Email not found",HttpStatus.NOT_FOUND);
    }
}
