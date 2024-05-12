package com.example.veronika.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;
@Data
@Entity
public class Tournament {
    @Id
    private Long tournamentId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "organizerId")
    private User organizer;
    private String tournamentName;
    private String format;
    private Long teamsCount;
    private String regulations;
    @OneToMany(mappedBy = "tournament", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Match> matchList;

    @OneToMany(mappedBy = "tournament", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Team> teamsList;

    // Конструкторы, геттеры и сеттеры
}
