package com.fullteam.controller;

import com.fullteam.model.Team;
import com.fullteam.model.types.GameType;
import com.fullteam.service.TeamService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class TeamController {

    private final TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }


    @GetMapping("/teams/{gameType}")
    public  String teamPage(@PathVariable String gameType, Model model) {
        model.addAttribute("gameType", gameType);
        return "teams";
    }

    @GetMapping("/team/register")
    public String teamRegister() {
        return "team_register";
    }

    @GetMapping("/team/{id}")
    public Optional<Team> getTeamById(@PathVariable Long id) {
        return teamService.findTeamById(id);
    }

    @GetMapping("/team/{gameType}/all-teams")
    public List<Team> findTeamsByGameType(@PathVariable GameType gameType) {
        System.out.println("In All Team By Game Type");
        List<Team> teams = teamService.findTeamsByGameTpe(gameType);
        System.out.println("I m in teams -----------------\n"+teams);
        return teams;
    }
}
