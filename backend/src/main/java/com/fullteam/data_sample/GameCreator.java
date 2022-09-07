package com.fullteam.data_sample;

import com.fullteam.model.Game;
import com.fullteam.model.types.GameType;
import com.fullteam.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GameCreator {
    private final GameService gameService;
    private List<Game> games = new ArrayList<>();
    @Autowired
    public GameCreator(GameService gameService) {
        this.gameService = gameService;
        initialize();
    }

    private void initialize() {
            Game game1 =
                    Game.builder()
                            .title("Mars")
                            .minPlayer((byte) 1)
                            .maxPlayer((byte) 5)
                            .description("Ducks taking over the Mars!")
                            .type(GameType.BOARD)
                            .build();
            Game game2 =
                    Game.builder()
                            .title("Monopoly")
                            .minPlayer((byte) 2)
                            .maxPlayer((byte) 5)
                            .description("Ducks taking over the capitalism!")
                            .type(GameType.BOARD)
                            .build();
            Game game3 =
                    Game.builder()
                            .title("Risk")
                            .minPlayer((byte) 2)
                            .maxPlayer((byte) 6)
                            .description("Ducks fighting for land!")
                            .type(GameType.BOARD)
                            .build();
            Game game4 =
                    Game.builder()
                            .title("Cascadia")
                            .minPlayer((byte) 1)
                            .maxPlayer((byte) 4)
                            .description("Ducks in the Nature!(Fiction)")
                            .type(GameType.BOARD)
                            .build();
            Game game5 =
                    Game.builder()
                            .title("Mars")
                            .minPlayer((byte) 1)
                            .maxPlayer((byte) 5)
                            .description("Ducks taking over the Mars now Online!")
                            .type(GameType.ONLINE)
                            .build();
            Game game6 =
                    Game.builder()
                            .title("Diplomacy")
                            .minPlayer((byte) 2)
                            .maxPlayer((byte) 7)
                            .description("Vote for the Duck Party! More bread less hunter!")
                            .type(GameType.ONLINE)
                            .build();
            Game game7 =
                    Game.builder()
                            .title("Dominion")
                            .minPlayer((byte) 2)
                            .maxPlayer((byte) 6)
                            .description("Make your dUcktopia!")
                            .type(GameType.ONLINE)
                            .build();
            Game game8 =
                    Game.builder()
                            .title("PathFinder")
                            .minPlayer((byte) 2)
                            .maxPlayer((byte) 8)
                            .description("Game for cool Ducks!")
                            .type(GameType.RPG)
                            .build();
            Game game9 =
                    Game.builder()
                            .title("Dungeons and Ducks")
                            .minPlayer((byte) 2)
                            .maxPlayer((byte) 8)
                            .description("Game for the coolest Ducks!")
                            .type(GameType.RPG)
                            .build();
            Game game10 =
                    Game.builder()
                            .title("Magic")
                            .minPlayer((byte) 2)
                            .maxPlayer((byte) 4)
                            .description("Card game for Ducks (with thumb)!")
                            .type(GameType.RPG)
                            .build();
            games.addAll(games);
            gameService.addAllGame(List.of(game1,game2,game3,game4,game5,game6,game7,game8,game9,game10));

    }

    public List<Game> getGames() {
        return games;
    }
}

