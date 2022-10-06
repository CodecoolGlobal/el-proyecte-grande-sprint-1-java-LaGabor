package com.fullteam.service;

import com.fullteam.model.Team;
import com.fullteam.model.types.GameType;
import com.fullteam.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Optional<Team> findTeamById(Long id) {
        return teamRepository.findById(id);
    }

    public List<Team> findTeamsByGameTpe(GameType gameType) {
        return teamRepository.findTeamsByGameType(gameType);
    }
}
