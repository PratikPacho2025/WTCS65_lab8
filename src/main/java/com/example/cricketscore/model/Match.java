package com.example.cricketscore.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity @Table(name="matches")
public class Match {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
    @ManyToOne @JoinColumn(name="team1_id") private Team team1;
    @ManyToOne @JoinColumn(name="team2_id") private Team team2;
    @ManyToOne @JoinColumn(name="batting_team_id") private Team currentBattingTeam;
    @ManyToOne @JoinColumn(name="bowling_team_id") private Team currentBowlingTeam;
    @ManyToOne @JoinColumn(name="striker_id") private Player currentStriker;
    @ManyToOne @JoinColumn(name="non_striker_id") private Player currentNonStriker;
    @ManyToOne @JoinColumn(name="bowler_id") private Player currentBowler;
    private String venue, format, status;
    private LocalDateTime matchDate;
    public Long getId(){return id;} public void setId(Long id){this.id=id;}
    public Team getTeam1(){return team1;} public void setTeam1(Team v){team1=v;}
    public Team getTeam2(){return team2;} public void setTeam2(Team v){team2=v;}
    public Team getCurrentBattingTeam(){return currentBattingTeam;} public void setCurrentBattingTeam(Team v){currentBattingTeam=v;}
    public Team getCurrentBowlingTeam(){return currentBowlingTeam;} public void setCurrentBowlingTeam(Team v){currentBowlingTeam=v;}
    public Player getCurrentStriker(){return currentStriker;} public void setCurrentStriker(Player v){currentStriker=v;}
    public Player getCurrentNonStriker(){return currentNonStriker;} public void setCurrentNonStriker(Player v){currentNonStriker=v;}
    public Player getCurrentBowler(){return currentBowler;} public void setCurrentBowler(Player v){currentBowler=v;}
    public String getVenue(){return venue;} public void setVenue(String v){venue=v;}
    public String getFormat(){return format;} public void setFormat(String v){format=v;}
    public String getStatus(){return status;} public void setStatus(String v){status=v;}
    public LocalDateTime getMatchDate(){return matchDate;} public void setMatchDate(LocalDateTime v){matchDate=v;}
}
