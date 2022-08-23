package com.fullteam.service.dao;

import java.util.*;
import java.util.stream.Collectors;

import com.fullteam.model.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class TeamMemory implements TeamDao {

    private final List<Team> storage;

    @Autowired
    public TeamMemory(List<Team> storage) {
        this.storage = storage;
    }

    @Override
    public void addTeam(Team team) {storage.add(team);}

    @Override
    public Team findById(int id) {
        return storage.stream().filter(team -> team.getId() == id).findFirst().orElse(null);
    }

    @Override
    public List<Integer> teamIds() {
        return storage.stream().map(Team::getId).collect(Collectors.toList());
    }

    @Override
    public List<Team> getTeams() {
        return storage;
    }

}
