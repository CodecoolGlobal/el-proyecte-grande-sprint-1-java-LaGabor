package com.fullteam.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fullteam.model.types.GameType;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


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
    private int id;

    @NonNull
    private String title;

    @Builder.Default
    private byte minPlayer = 2;

    @Builder.Default
    private byte maxPlayer = 4;

    @NonNull
    private GameType type;

    @Builder.Default
    private String description = "No description added yet.";

}
