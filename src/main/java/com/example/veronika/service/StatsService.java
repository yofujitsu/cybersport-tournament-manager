package com.example.veronika.service;

import com.example.veronika.entity.MatchStats;
import com.example.veronika.repos.StatsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatsService {

    private StatsRepository statsRepository;

    public StatsService(StatsRepository statsRepository) {
        this.statsRepository = statsRepository;
    }

    public MatchStats createStats(MatchStats stats) {
        return statsRepository.save(stats);
    }

    public MatchStats updateStats(Long statsId, MatchStats statsUpdates) {
        MatchStats stats = statsRepository.findById(statsId).orElse(null);
        if (stats != null) {
            stats.setFirstTeamScore(statsUpdates.getFirstTeamScore());
            stats.setSecondTeamScore(statsUpdates.getSecondTeamScore());
            statsRepository.save(stats);
        }
        return stats;
    }

    public void deleteStats(Long statsId) {
        statsRepository.deleteById(statsId);
    }
}
