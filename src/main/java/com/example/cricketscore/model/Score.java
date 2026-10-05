package com.example.cricketscore.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity @Table(name="scores")
public class Score {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
    @JsonIgnore @ManyToOne @JoinColumn(name="match_id") private Match match;
    @ManyToOne @JoinColumn(name="team_id") private Team team;
    private int runs, wickets, balls;
    @Transient public String getOvers(){return (balls/6)+"."+(balls%6);}
    public Long getId(){return id;} public void setId(Long id){this.id=id;}
    public Match getMatch(){return match;} public void setMatch(Match v){match=v;}
    public Team getTeam(){return team;} public void setTeam(Team v){team=v;}
    public int getRuns(){return runs;} public void setRuns(int v){runs=v;}
    public int getWickets(){return wickets;} public void setWickets(int v){wickets=v;}
    public int getBalls(){return balls;} public void setBalls(int v){balls=v;}
}
