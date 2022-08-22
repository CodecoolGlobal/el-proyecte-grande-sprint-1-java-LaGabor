package com.fullteam.service.dao;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.fullteam.model.Team;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;

@Qualifier("teamDao")
public interface TeamDao {

    void addTeam(Team team);

    Team findById(int id);

    List<Integer> teamIds();

    List<Team> getTeams();
}
