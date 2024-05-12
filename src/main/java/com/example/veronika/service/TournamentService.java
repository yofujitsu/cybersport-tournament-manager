package com.example.veronika.service;

import com.example.veronika.entity.Tournament;
import com.example.veronika.repos.TournamentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TournamentService {

    private final TournamentRepository tournamentRepository;

    public TournamentService(TournamentRepository tournamentRepository) {
        this.tournamentRepository = tournamentRepository;
    }

    public Tournament createTournament(Tournament tournament) {
        return tournamentRepository.save(tournament);
    }

    public void deleteTournament(Long id) {
        tournamentRepository.deleteById(id);
    }

    public Tournament updateTournament(Long id, Tournament tournamentUpdates) {
        Tournament tournament = tournamentRepository.findById(id).orElse(null);
        if (tournament != null) {
            tournament.setTournamentName(tournamentUpdates.getTournamentName());
            tournament.setFormat(tournamentUpdates.getFormat());
            tournamentRepository.save(tournament);
        }
        return tournament;
    }
}
