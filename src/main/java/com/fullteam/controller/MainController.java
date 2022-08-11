package com.fullteam.controller;

import com.fullteam.model.Profile;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Controller
public class MainController {
    @GetMapping("/")
    public  String MainPage() {
        return "index";
    }

    @GetMapping("/team_list/{gameType}")
    public  String teamPage() {
        return "Duck";
    }

    @GetMapping("/game_register")
    public  String gameRegister() {
        return "Duck";
    }

    @GetMapping("/register")
    public String register() {
        return "Duck";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    //Change it to Post!
    @GetMapping("/profile")
    public String profile(/*@RequestParam("profile_id") String profileId,*/ Model model) {
        model.addAttribute("species", "Duck");
        return "profile";
    }

    @GetMapping("/team_register")
    public String teamRegister() {
        return "team_register";
    }
}
