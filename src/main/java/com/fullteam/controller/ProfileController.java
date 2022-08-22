package com.fullteam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProfileController {

    //Change it to Post!
    @GetMapping("/profile")
    public String profile(/*@RequestParam("profile_id") String profileId,*/ Model model) {
        model.addAttribute("species", "Duck");
        return "profile";
    }
}
