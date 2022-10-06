package com.fullteam.repository;

import com.fullteam.model.Team;
import com.fullteam.model.types.GameType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {

    List<Team> findTeamsByGameType(GameType gameType);
}
