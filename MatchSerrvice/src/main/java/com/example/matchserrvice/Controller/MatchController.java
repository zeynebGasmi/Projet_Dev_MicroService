package com.example.matchserrvice.Controller;

import com.example.matchserrvice.Model.Match;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/matches")
public class MatchController {
    private Map<Long, Match> Listmatches = new HashMap<>();
    {
        Match match1 = new Match(1L, "Algerie vs Tunisie", 1L, 2L);
        Match match2 = new Match(2L, "Algerie vs Cameroon", 3L, 4L);
        Match match3 = new Match(3L, "Algerie vs Burkina", 1L, 3L);
        Match match5 = new Match(5L, "Algerie vs Egypte", 4L, 2L);
        Match match6 = new Match(5L, "Algerie vs Allmagne", 4L, 2L);
        Match match7 = new Match(5L, "Algerie vs France", 4L, 2L);
        Listmatches.put(match1.getId(), match1);
        Listmatches.put(match2.getId(), match2);
        Listmatches.put(match3.getId(), match3);
        Listmatches.put(match5.getId(), match5);
        Listmatches.put(match5.getId(), match6);
        Listmatches.put(match5.getId(), match7);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Match> getMatchById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(Listmatches.get(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMatchById(@PathVariable("id") Long id) {
        Listmatches.remove(id);
        return ResponseEntity.ok("Match deleted successfully");

    }
    @PostMapping
    public ResponseEntity<String> createMatch(@RequestBody Match match) {
        Listmatches.put(match.getId(), match);
        return ResponseEntity.ok("Match created successfully");
    }

    @PutMapping
    public ResponseEntity<Match> updateMatch(@PathVariable Long id, @RequestBody Match updatedMatch) {
        Match match = Listmatches.get(id);
        if (match != null) {
            match.setName(updatedMatch.getName());
            return ResponseEntity.ok(match);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
