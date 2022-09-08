package com.fullteam.data_sample;

import com.fullteam.model.Game;
import com.fullteam.model.types.GameType;
import com.fullteam.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
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
                            .country("Quackgaria")
                            .creationDate(LocalDate.of(2219,12,24))
                            .publisher("BoardDucks")
                            .build();
            Game game2 =
                    Game.builder()
                            .title("Monopoly")
                            .minPlayer((byte) 2)
                            .maxPlayer((byte) 5)
                            .description("Ducks taking over the capitalism!")
                            .type(GameType.BOARD)
                            .country("United Ducks")
                            .creationDate(LocalDate.of(1994,5,25))
                            .publisher("Bread of Life")
                            .build();
            Game game3 =
                    Game.builder()
                            .title("Risk")
                            .minPlayer((byte) 2)
                            .maxPlayer((byte) 6)
                            .description("Ducks fighting for land!")
                            .country("Breadzillia")
                            .type(GameType.BOARD)
                            .creationDate(LocalDate.of(2020,9,19))
                            .publisher("Funtastic Games")
                            .build();
            Game game4 =
                    Game.builder()
                            .title("Cascadia")
                            .minPlayer((byte) 1)
                            .maxPlayer((byte) 4)
                            .description("Ducks in the Nature!(Fiction)")
                            .country("QuackLand")
                            .type(GameType.BOARD)
                            .creationDate(LocalDate.of(2002,2,17))
                            .publisher("WaterBoard")
                            .build();
            Game game5 =
                    Game.builder()
                            .title("Mars")
                            .minPlayer((byte) 1)
                            .maxPlayer((byte) 5)
                            .description("Ducks taking over the Mars now Online!")
                            .country("Quackgaria")
                            .type(GameType.ONLINE)
                            .creationDate(LocalDate.of(2220,01,01))
                            .publisher("Cyber Wings")
                            .build();
            Game game6 =
                    Game.builder()
                            .title("Diplomacy")
                            .minPlayer((byte) 2)
                            .maxPlayer((byte) 7)
                            .description("Vote for the Duck Party! More bread less hunter!")
                            .type(GameType.ONLINE)
                            .creationDate(LocalDate.of(2017,12,20))
                            .publisher("FromSoftDuck")
                            .build();
            Game game7 =
                    Game.builder()
                            .title("Dominion")
                            .minPlayer((byte) 2)
                            .maxPlayer((byte) 6)
                            .description("Make your dUcktopia!")
                            .country("Feathorra")
                            .type(GameType.ONLINE)
                            .creationDate(LocalDate.of(1832,11,7))
                            .publisher("DucktyVision")
                            .build();
            Game game8 =
                    Game.builder()
                            .title("PathFinder")
                            .minPlayer((byte) 2)
                            .maxPlayer((byte) 8)
                            .description("Game for cool Ducks!")
                            .country("Beakstan")
                            .type(GameType.RPG)
                            .creationDate(LocalDate.of(1532,6,27))
                            .publisher("Cosmic Ducks")
                            .build();
            Game game9 =
                    Game.builder()
                            .title("Dungeons and Ducks")
                            .minPlayer((byte) 2)
                            .maxPlayer((byte) 8)
                            .description("Game for the coolest Ducks!")
                            .country("South Ducks")
                            .type(GameType.RPG)
                            .creationDate(LocalDate.of(1310,3,2))
                            .publisher("Cosmic Ducks")
                            .build();
            Game game10 =
                    Game.builder()
                            .title("Magic")
                            .minPlayer((byte) 2)
                            .maxPlayer((byte) 4)
                            .description("Card game for Ducks (with thumb)!")
                            .type(GameType.RPG)
                            .country("CatzeDoom")
                            .creationDate(LocalDate.of(2010,10,11))
                            .publisher("Tricky Wings")
                            .build();
            games.addAll(List.of(game1,game2,game3,game4,game5,game6,game7,game8,game9,game10));
            gameService.addAllGame(games);

    }

    public List<Game> getGames() {
        return games;
    }
}

