package com.example.veronika;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.example.veronika.entity.Team;
import com.example.veronika.entity.User;
import com.example.veronika.repos.TeamRepository;
import com.example.veronika.service.TeamService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TeamServiceTest {

    @InjectMocks
    private TeamService teamService;

    @Mock
    private TeamRepository teamRepository;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testRegisterTeam() {
        Team team = new Team();
        team.setTeamName("Dream Team");
        when(teamRepository.save(any(Team.class))).thenReturn(team);

        Team registered = teamService.registerTeam(team);
        assertNotNull(registered);
        assertEquals("Dream Team", registered.getTeamName());
    }

    @Test
    public void testAddPlayersToTeam() {
        Long teamId = 1L;
        Team team = new Team();
        team.setTeamId(teamId);
        List<User> players = new ArrayList<>();
        players.add(new User());

        when(teamRepository.findById(teamId)).thenReturn(Optional.of(team));
        when(teamRepository.save(any(Team.class))).thenReturn(team);

        Team updatedTeam = teamService.addPlayersToTeam(teamId, players);
        assertNotNull(updatedTeam);
        assertEquals(1, updatedTeam.getMembers().size());
    }

    @Test
    public void testDeleteTeam() {
        Long teamId = 1L;
        doNothing().when(teamRepository).deleteById(teamId);

        teamService.deleteTeam(teamId);
        verify(teamRepository, times(1)).deleteById(teamId);
    }
}
