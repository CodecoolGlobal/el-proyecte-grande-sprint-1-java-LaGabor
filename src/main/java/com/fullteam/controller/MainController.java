package com.fullteam.controller;

import com.fullteam.model.Profile;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
