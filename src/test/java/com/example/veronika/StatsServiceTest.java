package com.example.veronika;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.example.veronika.entity.MatchStats;
import com.example.veronika.repos.StatsRepository;
import com.example.veronika.service.StatsService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class StatsServiceTest {

    @InjectMocks
    private StatsService statsService;

    @Mock
    private StatsRepository statsRepository;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCreateStats() {
        MatchStats stats = new MatchStats();
        stats.setStatsId(1L);
        stats.setMatchId(1L);
        stats.setFirstTeamScore(3L);
        stats.setSecondTeamScore(1L);

        when(statsRepository.save(any(MatchStats.class))).thenReturn(stats);

        MatchStats created = statsService.createStats(stats);
        assertNotNull(created);
        assertEquals(3L, created.getFirstTeamScore());
        assertEquals(1L, created.getSecondTeamScore());
    }
}

