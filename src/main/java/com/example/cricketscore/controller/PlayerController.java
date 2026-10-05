package com.example.cricketscore.controller;
import com.example.cricketscore.model.Player; import com.example.cricketscore.service.PlayerService; import org.springframework.web.bind.annotation.*; import java.util.List;
@RestController @RequestMapping("/api/players") @CrossOrigin public class PlayerController {
    private final PlayerService service; public PlayerController(PlayerService service){this.service=service;}
    @GetMapping public List<Player> getPlayers(){return service.getAllPlayers();}
    @GetMapping("/team/{teamId}") public List<Player> getPlayersByTeam(@PathVariable Long teamId){return service.getPlayersByTeam(teamId);}
    @GetMapping("/{id}") public Player getPlayer(@PathVariable Long id){return service.getPlayer(id);}
    @PostMapping("/team/{teamId}") public Player createPlayer(@PathVariable Long teamId,@RequestBody Player player){return service.createPlayer(player,teamId);}
}
