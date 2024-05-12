package com.example.veronika.service;

import com.example.veronika.entity.Team;
import com.example.veronika.entity.User;
import com.example.veronika.repos.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService {

    private final TeamRepository teamRepository;

    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public Team registerTeam(Team team) {
        return teamRepository.save(team);
    }

    public Team addPlayersToTeam(Long teamId, List<User> players) {
        Team team = teamRepository.findById(teamId).orElse(null);
        if (team != null) {
            team.setMembers(players);
            teamRepository.save(team);
        }
        return team;
    }

    public void deleteTeam(Long teamId) {
        teamRepository.deleteById(teamId);
    }
}
