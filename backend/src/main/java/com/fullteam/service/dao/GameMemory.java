package com.fullteam.service.dao;

import com.fullteam.model.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Repository
public class GameMemory implements GameDao {
    private Set<Game> storage;

    @Autowired
    public GameMemory(List<Game> storage) {
        this.storage = new HashSet<>(storage);
    }

    @Override
    public void addGame(Game game) {
        storage.add(game);
    }

    @Override
    public List<Integer> gameIds() {
        return storage.stream().map(Game::getId).collect(Collectors.toList());
    }

    @Override
    public Set<Game> getGames() {
        return storage;
    }

    @Override
    public Game getGameById(int id) {
        return storage.stream().filter(game -> game.getId() == id).findFirst().orElse(null);
    }
}

