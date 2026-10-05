package com.example.cricketscore.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity @Table(name="teams")
public class Team {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
    @Column(nullable=false) private String name;
    @Column(nullable=false, unique=true) private String shortName;
    private String city;
    @JsonIgnore @OneToMany(mappedBy="team") private List<Player> players=new ArrayList<>();
    public Long getId(){return id;} public void setId(Long id){this.id=id;}
    public String getName(){return name;} public void setName(String name){this.name=name;}
    public String getShortName(){return shortName;} public void setShortName(String shortName){this.shortName=shortName;}
    public String getCity(){return city;} public void setCity(String city){this.city=city;}
    public List<Player> getPlayers(){return players;} public void setPlayers(List<Player> players){this.players=players;}
}
