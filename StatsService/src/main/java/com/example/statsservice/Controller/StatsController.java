package com.example.statsservice.Controller;

@RestController
@RequestMapping("/stats")
public class StatsController {

    @GetMapping("/team/{teamId}")
    public TeamStats getTeamStats(@PathVariable Long teamId) {
        // Implémentation pour récupérer les statistiques d'équipe
        // Utilisez les services correspondants pour récupérer les données nécessaires
        return new TeamStats();
    }

    @GetMapping("/player/{playerId}")
    public PlayerStats getPlayerStats(@PathVariable Long playerId) {
        // Implémentation pour récupérer les statistiques de joueur
        // Utilisez les services correspondants pour récupérer les données nécessaires
        return new PlayerStats();
    }
}
