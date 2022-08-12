package com.fullteam.dao;

import java.util.Optional;

import com.fullteam.model.Team;

public interface TeamDao {
    void addTeam(Team team);
    Optional<Team> findById(int id);
}
