package com.fullteam.service;


import com.fullteam.model.Game;
import com.fullteam.model.types.GameType;
import com.fullteam.service.dao.GameDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class GameService {
    GameDao gameDao;

    @Autowired
    public GameService(GameDao gameDao) {
        this.gameDao = gameDao;
    }

    public void addGame(Game game) {
        gameDao.addGame(game);
    }

    public Integer getFirstFreeId() {
        Integer id = 0;
        while (gameDao.gameIds().contains(id)) {
            id++;
        }
        return id;
    }

    public Set<Game> getGamesByType(GameType type) {
        return gameDao.getGames().stream().filter(game -> game.getType().equals(type)).collect(Collectors.toSet());
    }

    public void createGame(String title, GameType type, String description, byte minPlayer, byte maxPlayer) {
        Game game = Game.builder()
                .id(getFirstFreeId())
                .title(title)
                .type(type)
                .description(description)
                .minPlayer(minPlayer)
                .maxPlayer(maxPlayer)
                .build();
        gameDao.addGame(game);
    }

    public Set<Game> getAllGame() {
        return gameDao.getGames();
    }

    public Game getGameById(int id) {
        return gameDao.getGameById(id);
    }
}
