package com.fullteam.service;

import com.fullteam.model.Team;
import com.fullteam.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService {
    private final TeamRepository teamRepository;

    @Autowired
    public TeamService(TeamRepository teamRepository) {

        this.teamRepository = teamRepository;
    }

    public void addTeam(Team team) {
        teamRepository.save(team);
    }


    public List<Team> getTeams() {
        return teamRepository.findAll();
    }
}
