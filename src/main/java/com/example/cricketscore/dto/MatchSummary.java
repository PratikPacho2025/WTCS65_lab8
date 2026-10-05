package com.example.cricketscore.dto;

import com.example.cricketscore.model.Score;
import java.util.List;

public class MatchSummary {
    private Long matchId;
    private String status, venue, format, battingTeam, bowlingTeam, striker, nonStriker, bowler;
    private List<Score> scores;
    public Long getMatchId(){return matchId;} public void setMatchId(Long v){matchId=v;}
    public String getStatus(){return status;} public void setStatus(String v){status=v;}
    public String getVenue(){return venue;} public void setVenue(String v){venue=v;}
    public String getFormat(){return format;} public void setFormat(String v){format=v;}
    public String getBattingTeam(){return battingTeam;} public void setBattingTeam(String v){battingTeam=v;}
    public String getBowlingTeam(){return bowlingTeam;} public void setBowlingTeam(String v){bowlingTeam=v;}
    public String getStriker(){return striker;} public void setStriker(String v){striker=v;}
    public String getNonStriker(){return nonStriker;} public void setNonStriker(String v){nonStriker=v;}
    public String getBowler(){return bowler;} public void setBowler(String v){bowler=v;}
    public List<Score> getScores(){return scores;} public void setScores(List<Score> v){scores=v;}
}
