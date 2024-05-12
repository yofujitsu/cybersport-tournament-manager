package com.example.veronika.entity;


import com.example.veronika.entity.enums.UserRole;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String username;
    private String email;
    private String password;
    private boolean isAdmin;
    private String avatar;

    @Enumerated(EnumType.STRING)
    private UserRole role;

    @OneToMany(mappedBy = "organizer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Tournament> tournamentList;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "teamId") // Это имя столбца в таблице базы данных.
    private Team team;
}

