package com.example.veronika;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.example.veronika.entity.Tournament;
import com.example.veronika.repos.TournamentRepository;
import com.example.veronika.service.TournamentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

public class TournamentServiceTest {

    @InjectMocks
    private TournamentService tournamentService;

    @Mock
    private TournamentRepository tournamentRepository;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCreateTournament() {
        Tournament tournament = new Tournament();
        tournament.setTournamentName("Champions League");
        when(tournamentRepository.save(any(Tournament.class))).thenReturn(tournament);

        Tournament created = tournamentService.createTournament(tournament);
        assertNotNull(created);
        assertEquals("Champions League", created.getTournamentName());
    }

    @Test
    public void testDeleteTournament() {
        Long tournamentId = 1L;
        doNothing().when(tournamentRepository).deleteById(tournamentId);

        tournamentService.deleteTournament(tournamentId);
        verify(tournamentRepository, times(1)).deleteById(tournamentId);
    }

    @Test
    public void testUpdateTournament() {
        Tournament existing = new Tournament();
        existing.setTournamentId(1L);
        existing.setTournamentName("Old Name");

        Tournament updates = new Tournament();
        updates.setTournamentName("New Name");

        when(tournamentRepository.findById(1L)).thenReturn(Optional.of(existing));
        when(tournamentRepository.save(any(Tournament.class))).thenReturn(existing);

        Tournament updated = tournamentService.updateTournament(1L, updates);
        assertNotNull(updated);
        assertEquals("New Name", updated.getTournamentName());
    }
}

