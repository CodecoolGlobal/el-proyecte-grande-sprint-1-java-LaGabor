package com.fullteam.service.dao;

import java.util.List;

import com.fullteam.model.Team;
import org.springframework.beans.factory.annotation.Qualifier;

@Qualifier("teamDao")
public interface TeamDao {

    void addTeam(Team team);

    Team findById(int id);

    List<Integer> teamIds();

    List<Team> getTeams();
}
