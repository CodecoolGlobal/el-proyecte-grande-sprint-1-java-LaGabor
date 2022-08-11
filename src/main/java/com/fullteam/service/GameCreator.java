package com.fullteam.service;

import com.fullteam.model.Game;
import com.fullteam.model.GameType;
import org.springframework.stereotype.Service;

@Service
public class GameCreator {

    private static int id = 1;

    public Game creatGame(String title, byte minPlayer, byte maxPlayer, GameType gameType, String description) {

        return new Game(title,minPlayer,maxPlayer,gameType,description,id++);

    }
}
