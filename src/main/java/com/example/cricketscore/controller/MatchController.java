package com.example.cricketscore.controller;
import com.example.cricketscore.dto.MatchSummary; import com.example.cricketscore.model.Match; import com.example.cricketscore.service.MatchService; import org.springframework.web.bind.annotation.*; import java.util.List;
@RestController @RequestMapping("/api/matches") @CrossOrigin public class MatchController {
    private final MatchService service; public MatchController(MatchService service){this.service=service;}
    @GetMapping public List<Match> getMatches(){return service.getAllMatches();}
    @GetMapping("/live") public List<Match> getLiveMatches(){return service.getLiveMatches();}
    @GetMapping("/{id}") public Match getMatch(@PathVariable Long id){return service.getMatch(id);}
    @GetMapping("/{id}/summary") public MatchSummary getSummary(@PathVariable Long id){return service.getSummary(id);}
    @PostMapping public Match createMatch(@RequestBody Match match){return service.createMatch(match);}
    @PutMapping("/{id}/status") public Match updateStatus(@PathVariable Long id,@RequestParam String status){return service.updateStatus(id,status);}
}
