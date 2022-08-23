package com.fullteam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class MainController {

    @GetMapping("/")
    public  String MainPage() {
        return "index";
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




}
