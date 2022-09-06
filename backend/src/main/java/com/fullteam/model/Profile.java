package com.fullteam.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fullteam.model.types.GameType;
import lombok.*;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Profile {

    @Column(updatable = false)
    private  String name;
    @Column(updatable = false)
    private  LocalDate birthDate;
    private final LocalDate registrationDate = LocalDate.now();
    @Builder.Default
    private  String description = "No description added yet.";
    @Builder.Default
    @ManyToMany
    private Set<Game> ownedOnlineGames = new HashSet<>();
    @Builder.Default
    @ManyToMany
    private Set<Game> ownedBoardGames = new HashSet<>();

    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(updatable = false)
    private  Long id;

}
