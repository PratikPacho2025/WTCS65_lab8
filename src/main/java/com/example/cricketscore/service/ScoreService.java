package com.example.cricketscore.service;
import com.example.cricketscore.dto.ScoreUpdateRequest;
import com.example.cricketscore.model.*;
import com.example.cricketscore.repository.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;
import java.util.List;
@Service public class ScoreService {
    private final ScoreRepository scores; private final MatchRepository matches; private final TeamRepository teams; private final PlayerRepository players; private final MatchEventRepository events;
    public ScoreService(ScoreRepository scores,MatchRepository matches,TeamRepository teams,PlayerRepository players,MatchEventRepository events){this.scores=scores;this.matches=matches;this.teams=teams;this.players=players;this.events=events;}
    public List<Score> getScores(Long matchId){return scores.findByMatchId(matchId);}
    public List<MatchEvent> getEvents(Long matchId){return events.findByMatchIdOrderByIdDesc(matchId);}
    @Transactional public MatchEvent addEvent(Long matchId,ScoreUpdateRequest req){
        Match match=matches.findById(matchId).orElseThrow(()->new RuntimeException("Match not found"));
        Team team=teams.findById(req.getTeamId()).orElseThrow(()->new RuntimeException("Team not found"));
        Player batsman=req.getBatsmanId()==null?null:players.findById(req.getBatsmanId()).orElseThrow(()->new RuntimeException("Batsman not found"));
        Player bowler=req.getBowlerId()==null?null:players.findById(req.getBowlerId()).orElseThrow(()->new RuntimeException("Bowler not found"));
        Score score=scores.findByMatchIdAndTeamId(matchId,team.getId()).orElseGet(()->{Score x=new Score();x.setMatch(match);x.setTeam(team);return x;});
        score.setRuns(score.getRuns()+req.getRuns()); if(req.isWicket())score.setWickets(score.getWickets()+1); score.setBalls(score.getBalls()+1); scores.save(score);
        MatchEvent e=new MatchEvent(); e.setMatch(match);e.setTeam(team);e.setBatsman(batsman);e.setBowler(bowler);e.setEventType(req.getEventType()==null?"RUN":req.getEventType());e.setRuns(req.getRuns());e.setWicket(req.isWicket());e.setOverNumber(score.getBalls()/6);e.setBallNumber(score.getBalls()%6);e.setCreatedAt(LocalDateTime.now());
        String d=req.isWicket()?"WICKET":req.getRuns()==0?"DOT BALL":req.getRuns()==4?"FOUR":req.getRuns()==6?"SIX":req.getRuns()+" RUN"; e.setDescription(d); return events.save(e);
    }
}
