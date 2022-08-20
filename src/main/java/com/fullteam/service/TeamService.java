package com.fullteam.service;

import com.fullteam.model.Team;
import com.fullteam.service.dao.TeamDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService {
    TeamDao teamDao;

    @Autowired
    public TeamService(TeamDao teamDao) {
        this.teamDao = teamDao;
    }

    public void addTeam(Team team) {
        teamDao.addTeam(team);
    }

    private Integer getFirstFreeId() {
        Integer id = 0;
        while (teamDao.teamIds().contains(id)) {
            id++;
        }
        return id;
    }

    public List<Team> getTeams() {
        return teamDao.getTeams();
    }
}
