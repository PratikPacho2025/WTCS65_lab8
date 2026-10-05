package com.example.cricketscore.service;
import com.example.cricketscore.dto.MatchSummary;
import com.example.cricketscore.model.Match;
import com.example.cricketscore.model.Score;
import com.example.cricketscore.repository.MatchRepository;
import com.example.cricketscore.repository.ScoreRepository;
import org.springframework.stereotype.Service;
import java.util.List;
@Service public class MatchService {
    private final MatchRepository matches; private final ScoreRepository scores;
    public MatchService(MatchRepository matches,ScoreRepository scores){this.matches=matches;this.scores=scores;}
    public List<Match> getAllMatches(){return matches.findAll();}
    public List<Match> getLiveMatches(){return matches.findByStatusIgnoreCase("LIVE");}
    public Match getMatch(Long id){return matches.findById(id).orElseThrow(()->new RuntimeException("Match not found"));}
    public Match createMatch(Match m){return matches.save(m);}
    public Match updateStatus(Long id,String status){Match m=getMatch(id);m.setStatus(status);return matches.save(m);}
    public MatchSummary getSummary(Long id){
        Match m=getMatch(id); MatchSummary s=new MatchSummary(); s.setMatchId(m.getId()); s.setStatus(m.getStatus()); s.setVenue(m.getVenue()); s.setFormat(m.getFormat());
        if(m.getCurrentBattingTeam()!=null)s.setBattingTeam(m.getCurrentBattingTeam().getName());
        if(m.getCurrentBowlingTeam()!=null)s.setBowlingTeam(m.getCurrentBowlingTeam().getName());
        if(m.getCurrentStriker()!=null)s.setStriker(m.getCurrentStriker().getName());
        if(m.getCurrentNonStriker()!=null)s.setNonStriker(m.getCurrentNonStriker().getName());
        if(m.getCurrentBowler()!=null)s.setBowler(m.getCurrentBowler().getName());
        s.setScores(scores.findByMatchId(id)); return s;
    }
}
