package com.fullteam.repository;

import com.fullteam.model.Game;
import com.fullteam.model.types.GameType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {
    Optional<Game> findByTitle(String title);

    Optional<Game> findByTitleAndType(String title, GameType type);
}
