package com.fullteam.dao;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import com.fullteam.model.Team;

public class InMemoryTeamDao implements TeamDao {

    private Map<Integer, Team> storage = new HashMap<>();
    private int idCounter = 1;

    @Override
    public void addTeam(Team team) {
        // TODO Auto-generated method stub
        storage.put(idCounter++, team);
    }

    @Override
    public Optional<Team> findById(int id) {
        if (storage.containsKey(id)) {
            return Optional.of(storage.get(id));
        }
        return Optional.empty();
    }

}
