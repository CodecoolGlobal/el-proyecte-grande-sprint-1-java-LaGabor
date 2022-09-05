package com.fullteam.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Team {

    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(updatable = false)
    private Long id;

    @Builder.Default
    private String teamName = "Annonymous";

    @Builder.Default
    private String teamDescription = "No description added yet.";

    @Column(updatable = false)
    private byte maxWantedTeamSize;

    @Column(updatable = false)
    private byte minWantedTeamSize;

    private byte freePlaces;

    @Builder.Default
    @ManyToOne
    private Game game = null;

    @ManyToOne
    private Profile admin;

    private final LocalDate teamCreated = LocalDate.now();

    @Builder.Default
    @OneToMany
    private List<Profile> players = new ArrayList<>();


    public void setAdmin(Profile admin) {
        if (this.admin == null) {
            this.admin = admin;
            this.players.set(this.players.indexOf(null), this.admin);
        }
        else {
            throw new IllegalArgumentException("Team is already have a team leader");
        }
    }

    public void setGame(Game game) {
        if (this.game == null) {
            this.game = game;
        }
        else {
            throw new IllegalArgumentException("Team is already have a game");
        }
    }


}
