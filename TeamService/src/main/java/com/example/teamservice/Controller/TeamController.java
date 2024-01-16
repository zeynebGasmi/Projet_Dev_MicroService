package com.example.teamservice.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



import com.beans.Team;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/teams")

@Service
public class TeamController {
    private Map<Long, Team> teams = new HashMap<>();

    //initializing teams
    {
        Team team1 = new Team(1L, "Real Madrid");
        Team team2 = new Team(2L, "Barcelona");
        Team team3 = new Team(3L, "Bayern Munich");
        Team team4 = new Team(4L, "Manchester United");
        Team team5 = new Team(5L, "Juventus");
        teams.put(team1.getId(), team1);
        teams.put(team2.getId(), team2);
        teams.put(team3.getId(), team3);
        teams.put(team4.getId(), team4);
        teams.put(team5.getId(), team5);
    }
    @GetMapping("/")
    public ResponseEntity<Map<Long, Team>> getAllTeams() {
        return ResponseEntity.ok(teams);
    }
    @GetMapping("/teamsName")
    public ResponseEntity<List<String>> getAllTeamsName() {
        List<String> teamsName = new ArrayList<>();
        for (Team team : teams.values()) {
            teamsName.add(team.getName());
        }
        return ResponseEntity.ok(teamsName);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Team> getTeamById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(teams.get(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTeamById(@PathVariable("id") Long id) {
        teams.remove(id);
        return ResponseEntity.ok("Team deleted successfully");

    }

    @PostMapping
    public ResponseEntity<String> createTeam(@RequestBody Team team) {
        teams.put(team.getId(), team);
        return ResponseEntity.ok("Team created successfully");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Team> updateTeam(@PathVariable Long id, @RequestBody Team updatedTeam) {
        Team team = teams.get(id);
        if (team != null) {
            team.setName(updatedTeam.getName());
            return ResponseEntity.ok(team);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}