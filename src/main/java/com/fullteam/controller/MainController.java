package com.fullteam.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {
    @GetMapping("/")
    public  String MainPage() {
        return "index";
    }

    @GetMapping("/teams/{gameType}")
    public  String teamPage(@PathVariable String gameType, Model model) {
        model.addAttribute("gameType", gameType);
        return "teams";
    }

    @GetMapping("/game_register")
    public  String gameRegister(Model model) {
        if (model.getAttribute("profile") == null) {
            model.addAttribute("denied", "Permission denied, you are not logged in");
            return "redirect:";
        }
        return "game_register";
    }

    @GetMapping("/register")
    public String register() {
        System.out.println("In there");
        return "register";
    }

    @GetMapping("/login")
    public String login() {
        return "Duck";
    }

    @PostMapping("/profile")
    public String profile(@Value("profile_id") String profileId) {
        return "Duck";
    }

    @GetMapping("/team_register")
    public String teamRegister() {
        return "Duck";
    }
}
