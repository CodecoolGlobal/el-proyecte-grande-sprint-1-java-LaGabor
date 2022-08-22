package com.fullteam.service.dao;

import com.fullteam.model.Game;

import java.util.List;
import java.util.Set;

public interface GameDao {

    void addGame(Game game);

    List<Integer> gameIds();

    Set<Game> getGames();
}
