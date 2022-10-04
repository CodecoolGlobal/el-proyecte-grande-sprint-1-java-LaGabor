package com.fullteam.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fullteam.security.UserRole;
import lombok.*;
import javax.persistence.*;
import java.time.LocalDate;
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

    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(updatable = false)
    private  Long id;

    @JsonIgnore
    private String password;

    @Column(unique = true)
    private String email;

    @Column(updatable = false)
    private  String username;

    @Enumerated(EnumType.STRING)
    private UserRole roles;

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

}
