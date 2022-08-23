package com.fullteam.data_sample;

import com.fullteam.model.Game;
import com.fullteam.model.types.GameType;
import com.fullteam.service.dao.GameMemory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GameCreator {
    GameMemory gameMemory;

    @Autowired
    public GameCreator(GameMemory gameMemory) {
        this.gameMemory = gameMemory;
        initialize();
    }

    private void initialize() {
        gameMemory.addGame(
                Game.builder()
                        .id(0)
                        .title("Mars")
                        .minPlayer((byte) 1)
                        .maxPlayer((byte) 5)
                        .description("Ducks taking over the Mars!")
                        .type(GameType.BOARD)
                        .build());
        gameMemory.addGame(
                Game.builder()
                        .id(1)
                        .title("Monopoly")
                        .minPlayer((byte) 2)
                        .maxPlayer((byte) 5)
                        .description("Ducks taking over the capitalism!")
                        .type(GameType.BOARD)
                        .build());
        gameMemory.addGame(
                Game.builder()
                        .id(2)
                        .title("Risk")
                        .minPlayer((byte) 2)
                        .maxPlayer((byte) 6)
                        .description("Ducks fighting for land!")
                        .type(GameType.BOARD)
                        .build());
        gameMemory.addGame(
                Game.builder()
                        .id(3)
                        .title("Cascadia")
                        .minPlayer((byte) 1)
                        .maxPlayer((byte) 4)
                        .description("Ducks in the Nature!(Fiction)")
                        .type(GameType.BOARD)
                        .build());
        gameMemory.addGame(
                Game.builder()
                        .id(4)
                        .title("Mars")
                        .minPlayer((byte) 1)
                        .maxPlayer((byte) 5)
                        .description("Ducks taking over the Mars now Online!")
                        .type(GameType.ONLINE)
                        .build());
        gameMemory.addGame(
                Game.builder()
                        .id(5)
                        .title("Diplomacy")
                        .minPlayer((byte) 2)
                        .maxPlayer((byte) 7)
                        .description("Vote for the Duck Party! More bread less hunter!")
                        .type(GameType.ONLINE)
                        .build());
        gameMemory.addGame(
                Game.builder()
                        .id(6)
                        .title("Dominion")
                        .minPlayer((byte) 2)
                        .maxPlayer((byte) 6)
                        .description("Make your dUcktopia!")
                        .type(GameType.ONLINE)
                        .build());
        gameMemory.addGame(
                Game.builder()
                        .id(7)
                        .title("PathFinder")
                        .minPlayer((byte) 2)
                        .maxPlayer((byte) 8)
                        .description("Game for cool Ducks!")
                        .type(GameType.RPG)
                        .build());
        gameMemory.addGame(
                Game.builder()
                        .id(8)
                        .title("Dungeons and Ducks")
                        .minPlayer((byte) 2)
                        .maxPlayer((byte) 8)
                        .description("Game for the coolest Ducks!")
                        .type(GameType.RPG)
                        .build());
        gameMemory.addGame(
                Game.builder()
                        .id(9)
                        .title("Magic")
                        .minPlayer((byte) 2)
                        .maxPlayer((byte) 4)
                        .description("Card game for Ducks (with thumb)!")
                        .type(GameType.RPG)
                        .build());
    }
}

