package com.fullteam.controller;

import com.fullteam.controller.dto.LoginDto;
import com.fullteam.controller.dto.RegistrationProfileDto;
import com.fullteam.model.Profile;
import com.fullteam.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@Controller
public class AuthenticationController {

    private  final ProfileService profileService;

    @Autowired
    public AuthenticationController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @GetMapping("authentication/check/profile/{name}")
    public @ResponseBody boolean checkProfileNameExistence(@PathVariable String name) {
        return profileService.checkProfileNameExistence(name);
    }

    @GetMapping("authentication/check/email/{email}")
    public @ResponseBody boolean checkEmailExistence(@PathVariable String email) {
        return profileService.checkEmailExistence(email);
    }


    @PostMapping("authentication/create/profile")
    public ResponseEntity<String> createNewProfile(@RequestBody RegistrationProfileDto registrationProfileDto) {
        profileService.saveProfileFromDto(registrationProfileDto);
        return new ResponseEntity<>("Profile successfully saved", HttpStatus.OK);
    }

    @PostMapping("authentication/login")
    public ResponseEntity<String> login(@RequestBody LoginDto loginDto) {
        return profileService.profileLogin(loginDto);
    }
}
