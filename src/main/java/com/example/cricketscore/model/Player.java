package com.example.cricketscore.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity @Table(name="players")
public class Player {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
    @Column(nullable=false) private String name;
    private String role, battingStyle, bowlingStyle;
    @JsonIgnore @ManyToOne(fetch=FetchType.LAZY) @JoinColumn(name="team_id") private Team team;
    public Long getId(){return id;} public void setId(Long id){this.id=id;}
    public String getName(){return name;} public void setName(String name){this.name=name;}
    public String getRole(){return role;} public void setRole(String role){this.role=role;}
    public String getBattingStyle(){return battingStyle;} public void setBattingStyle(String battingStyle){this.battingStyle=battingStyle;}
    public String getBowlingStyle(){return bowlingStyle;} public void setBowlingStyle(String bowlingStyle){this.bowlingStyle=bowlingStyle;}
    public Team getTeam(){return team;} public void setTeam(Team team){this.team=team;}
}
