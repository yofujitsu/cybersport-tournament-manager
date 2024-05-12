package com.example.veronika.repos;

import com.example.veronika.entity.Match;
import com.example.veronika.entity.MatchStats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatsRepository extends JpaRepository<MatchStats, Long> {
}
