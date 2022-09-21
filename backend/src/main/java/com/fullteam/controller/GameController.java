package com.fullteam.controller;

import com.fullteam.controller.dto.GameDto;
import com.fullteam.model.Game;
import com.fullteam.model.types.GameType;
import com.fullteam.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class GameController {

    private GameService gameService;

    @Autowired
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @PostMapping("/game/register")
    public String gameRegister(@RequestBody GameDto gameDto, Model model) {
            gameService.createGame(gameDto.getTitle(), gameDto.getGameType(), gameDto.getDescription(), gameDto.getMinPlayer(), gameDto.getMaxPlayer());
            return "redirect:/game/all/";
        }

    @GetMapping("/game/register")
    public String gameRegister() {
        System.out.println("GET /game/register");
        return "gameRegister";
    }

    @GetMapping("/game/list/{gameType}")
    public @ResponseBody Set<Game> gameList(@PathVariable GameType gameType) {
        return gameService.getGamesByType(gameType);
    }

    @GetMapping("/games")
    public @ResponseBody List<Game> allGame() {
        return gameService.getAllGame();
    }

    @GetMapping("/game/{type}/{title}")
    public @ResponseBody Optional<Game> gameByGameTypeAndTitle(@PathVariable String title, @PathVariable GameType type) {
        Optional<Game> game = gameService.findByTitleAndType(title, type);
        System.out.println("Before response " + game);
        return game;
    }

}
