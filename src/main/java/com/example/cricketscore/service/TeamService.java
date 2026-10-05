package com.example.cricketscore.service;
import com.example.cricketscore.model.Team;
import com.example.cricketscore.repository.TeamRepository;
import org.springframework.stereotype.Service;
import java.util.List;
@Service public class TeamService {
    private final TeamRepository repo; public TeamService(TeamRepository repo){this.repo=repo;}
    public List<Team> getAllTeams(){return repo.findAll();}
    public Team getTeam(Long id){return repo.findById(id).orElseThrow(()->new RuntimeException("Team not found"));}
    public Team createTeam(Team team){return repo.save(team);}
}
