package com.example.teamservice.Model;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class Team {

    private final RestTemplate restTemplate;
    private static final String PLAYER_SERVICE_URL = "http://player-service/api/players/";
    @Autowired
    public Team(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Player getPlayerById(Long playerId) {
        return restTemplate.getForObject(PLAYER_SERVICE_URL + playerId, Player.class);
    }
}