package com.example.cricketscore.controller;
import com.example.cricketscore.model.Team; import com.example.cricketscore.service.TeamService; import org.springframework.web.bind.annotation.*; import java.util.List;
@RestController @RequestMapping("/api/teams") @CrossOrigin public class TeamController {
    private final TeamService service; public TeamController(TeamService service){this.service=service;}
    @GetMapping public List<Team> getTeams(){return service.getAllTeams();}
    @GetMapping("/{id}") public Team getTeam(@PathVariable Long id){return service.getTeam(id);}
    @PostMapping public Team createTeam(@RequestBody Team team){return service.createTeam(team);}
}
