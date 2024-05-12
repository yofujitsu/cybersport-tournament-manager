package com.example.veronika.repos;

import com.example.veronika.entity.Match;
import com.example.veronika.entity.Tournament;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TournamentRepository extends JpaRepository<Tournament, Long> {
}
