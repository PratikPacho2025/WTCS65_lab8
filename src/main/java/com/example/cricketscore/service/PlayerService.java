package com.example.cricketscore.service;
import com.example.cricketscore.model.Player;
import com.example.cricketscore.model.Team;
import com.example.cricketscore.repository.PlayerRepository;
import com.example.cricketscore.repository.TeamRepository;
import org.springframework.stereotype.Service;
import java.util.List;
@Service public class PlayerService {
    private final PlayerRepository players; private final TeamRepository teams;
    public PlayerService(PlayerRepository players,TeamRepository teams){this.players=players;this.teams=teams;}
    public List<Player> getAllPlayers(){return players.findAll();}
    public List<Player> getPlayersByTeam(Long teamId){return players.findByTeamId(teamId);}
    public Player getPlayer(Long id){return players.findById(id).orElseThrow(()->new RuntimeException("Player not found"));}
    public Player createPlayer(Player p,Long teamId){Team t=teams.findById(teamId).orElseThrow(()->new RuntimeException("Team not found"));p.setTeam(t);return players.save(p);}
}
