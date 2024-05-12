package com.example.veronika.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;
@Entity
@Data
public class Team {
    @Id
    private Long teamId;
    private String teamName;
    private String teamLogo;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "captainId")
    private User captain;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tournamentId")
    private Tournament tournament;

    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<User> members;

    // Конструкторы, геттеры и сеттеры
}
