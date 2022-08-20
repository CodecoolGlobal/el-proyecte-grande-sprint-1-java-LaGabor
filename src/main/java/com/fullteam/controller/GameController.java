package com.fullteam.controller;

import com.fullteam.controller.dto.GameDto;
import com.fullteam.controller.dto.GameTypeDto;
import com.fullteam.model.Game;
import com.fullteam.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@Controller
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

    @PostMapping("/game/list/{}")
    public @ResponseBody Set<Game> gameList(@RequestBody GameTypeDto gameType) {
        return gameService.getGamesByType(gameType.getGameType());
    }

    @GetMapping("/game/all-games")
    public String allGame(Model model) {
        model.addAttribute("games", gameService.getAllGame());
        return "all_games";
    }

}
