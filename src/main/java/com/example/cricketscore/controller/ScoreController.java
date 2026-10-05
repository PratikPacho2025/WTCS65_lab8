package com.example.cricketscore.controller;
import com.example.cricketscore.dto.ScoreUpdateRequest; import com.example.cricketscore.model.MatchEvent; import com.example.cricketscore.model.Score; import com.example.cricketscore.service.ScoreService; import org.springframework.web.bind.annotation.*; import java.util.List;
@RestController @RequestMapping("/api/scores") @CrossOrigin public class ScoreController {
    private final ScoreService service; public ScoreController(ScoreService service){this.service=service;}
    @GetMapping("/match/{matchId}") public List<Score> getScores(@PathVariable Long matchId){return service.getScores(matchId);}
    @GetMapping("/match/{matchId}/events") public List<MatchEvent> getEvents(@PathVariable Long matchId){return service.getEvents(matchId);}
    @PostMapping("/match/{matchId}/event") public MatchEvent addEvent(@PathVariable Long matchId,@RequestBody ScoreUpdateRequest request){return service.addEvent(matchId,request);}
}
