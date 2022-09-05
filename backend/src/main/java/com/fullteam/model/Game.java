package com.fullteam.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fullteam.model.types.GameType;
import lombok.*;

import javax.persistence.*;


@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Game {

    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(updatable = false)
    private Long id;

    @NonNull
    @Column(updatable = false)
    private String title;

    @Builder.Default
    @Column(updatable = false)
    private byte minPlayer = 2;

    @Column(updatable = false)
    private byte maxPlayer;

    @NonNull
    @Column(updatable = false)
    private GameType type;

    @Builder.Default
    private String description = "No description added yet.";

}
