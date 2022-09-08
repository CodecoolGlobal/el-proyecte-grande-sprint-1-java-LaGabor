package com.fullteam.service;


import com.fullteam.model.Game;
import com.fullteam.model.types.GameType;
import com.fullteam.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class GameService {
    private final GameRepository gameRepository;

    @Autowired
    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public void addGame(Game game) {
        gameRepository.save(game);
    }

    public void addAllGame(List<Game> games){
        for(Game game: games){
            gameRepository.save(game);
        }
    }

    public Set<Game> getGamesByType(GameType type) {
        return gameRepository.findAll().stream().filter(game -> game.getType().equals(type)).collect(Collectors.toSet());
    }

    public void createGame(String title, GameType type, String description, byte minPlayer, byte maxPlayer) {
        Game game = Game.builder()
                .title(title)
                .type(type)
                .description(description)
                .minPlayer(minPlayer)
                .maxPlayer(maxPlayer)
                .build();
        gameRepository.save(game);
    }

    public List<Game> getAllGame() {
        return gameRepository.findAll();
    }

    public Optional<Game> getGameById(Long id) {
        return gameRepository.findById(id);
    }

    public Optional<Game> getGameByName(String name) {
        return gameRepository.findByName(name);
    }
}
