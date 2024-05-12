package com.example.veronika.service;

import com.example.veronika.entity.Match;
import com.example.veronika.repos.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MatchService {
    private final MatchRepository matchRepository;

    public MatchService(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }

    public Match createMatch(Match match) {
        return matchRepository.save(match);
    }

    public void deleteMatch(Long matchId) {
        matchRepository.deleteById(matchId);
    }
}
