package com.example.playerserrvice.Controller;
import com.example.playerserrvice.Model.Player;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.playerserrvice.Model.Player;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = "PlayerController", description = "REST Apis related to Player Entity!!!!")

@RestController
@RequestMapping("/players")
public class PlayerController {

    List<Player> players = new ArrayList<Player>();
    {
        players.add(new Player(111,"Sajal"));
        players.add(new Player(222,"Lokesh"));
        players.add(new Player(333,"Kajal"));
        players.add(new Player(444,"Sukesh"));
    }


    public PlayerController(List<Player> players) {
        this.players = players;
    }


    @GetMapping("GET/players/{id}")
    public Player getPlayerById(@PathVariable int id) {
        return players.stream()
                .filter(player -> player.getId()==(id))
                .findFirst()  // Returns an Optional<Player> which might be null if not found
                .orElse(null);
    }
    // ajouter un nouveau joueur
    @PostMapping("POST/players")
    public Player addPlayer(@RequestBody int id, @RequestBody String name) {
        Player p1 = new Player(id, name);
        players.add(p1);
        return p1;
    }
    // mettre à jour les infor d'un joueur existant
    @PutMapping("PUT/players/{id}")
    public Player updatePlayer(@PathVariable Long id) {

        for (Player player2 : players) {
            if (player2.getId()==(id)) {
                // Add the student to the list if the class matches
                player2.setName("your name is modified");
                System.out.println("player is modified by its ID");
                return player2;
            }
        }
        return null;
    }
    // Supprimer un jour by ID
    @DeleteMapping("DELETE/players/{id}")
    public void deletePlayer(@PathVariable Long id) {
        for (Player player3 : players) {
            if (player3.getId()==(id)) {
                players.remove(player3);
            }
        }
    }
}
