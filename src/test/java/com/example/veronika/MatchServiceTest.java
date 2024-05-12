package com.example.veronika;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.example.veronika.entity.Match;
import com.example.veronika.entity.MatchStats;
import com.example.veronika.entity.Tournament;
import com.example.veronika.repos.MatchRepository;
import com.example.veronika.service.MatchService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

public class MatchServiceTest {

    @InjectMocks
    private MatchService matchService;

    @Mock
    private MatchRepository matchRepository;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCreateMatch() {
        Match match = new Match();
        Tournament tournament = new Tournament();
        match.setMatchId(1L);
        match.setTournament(tournament);
        match.setFirstTeamId(1L);
        match.setSecondTeamId(2L);
        match.setResult("2-1");
        match.setMatchDate(new Date());

        when(matchRepository.save(any(Match.class))).thenReturn(match);

        Match created = matchService.createMatch(match);
        assertNotNull(created);
        assertEquals(tournament, created.getTournament());
        assertEquals("2-1", created.getResult());
    }
}
