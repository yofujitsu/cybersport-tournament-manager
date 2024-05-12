package com.example.veronika.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class Match {
    @Id
    private Long matchId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tournamentId", referencedColumnName = "tournamentId")
    private Tournament tournament;
    private Long firstTeamId;
    private Long secondTeamId;
    private String result;
    private Date matchDate;
    @ManyToOne
    @JoinColumn(name = "match_stats_id")
    private MatchStats matchStats;

    // Конструкторы, геттеры и сеттеры
}

