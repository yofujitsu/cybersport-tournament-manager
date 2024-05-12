package com.example.veronika.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
@Entity
@Data
public class MatchStats {
    @Id
    private Long statsId;
    private Long matchId;
    private Long firstTeamScore;
    private Long secondTeamScore;

}
