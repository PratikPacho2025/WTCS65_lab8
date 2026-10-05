package com.example.cricketscore.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity @Table(name="match_events")
public class MatchEvent {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
    @JsonIgnore @ManyToOne @JoinColumn(name="match_id") private Match match;
    @ManyToOne @JoinColumn(name="team_id") private Team team;
    @ManyToOne @JoinColumn(name="batsman_id") private Player batsman;
    @ManyToOne @JoinColumn(name="bowler_id") private Player bowler;
    private String eventType;
    private int runs;
    private boolean wicket;
    private int overNumber, ballNumber;
    private String description;
    private LocalDateTime createdAt;
    public Long getId(){return id;} public void setId(Long v){id=v;}
    public Match getMatch(){return match;} public void setMatch(Match v){match=v;}
    public Team getTeam(){return team;} public void setTeam(Team v){team=v;}
    public Player getBatsman(){return batsman;} public void setBatsman(Player v){batsman=v;}
    public Player getBowler(){return bowler;} public void setBowler(Player v){bowler=v;}
    public String getEventType(){return eventType;} public void setEventType(String v){eventType=v;}
    public int getRuns(){return runs;} public void setRuns(int v){runs=v;}
    public boolean isWicket(){return wicket;} public void setWicket(boolean v){wicket=v;}
    public int getOverNumber(){return overNumber;} public void setOverNumber(int v){overNumber=v;}
    public int getBallNumber(){return ballNumber;} public void setBallNumber(int v){ballNumber=v;}
    public String getDescription(){return description;} public void setDescription(String v){description=v;}
    public LocalDateTime getCreatedAt(){return createdAt;} public void setCreatedAt(LocalDateTime v){createdAt=v;}
}
