package com.example.cricketscore;

import com.example.cricketscore.model.*;
import com.example.cricketscore.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@SpringBootApplication
public class CricketScoreApplication {
    public static void main(String[] args) { SpringApplication.run(CricketScoreApplication.class, args); }

    @Bean
    CommandLineRunner seedData(TeamRepository teams, PlayerRepository players, MatchRepository matches, ScoreRepository scores) {
        return args -> {
            if (teams.count() > 0) return;

            Team india = new Team(); india.setName("India"); india.setShortName("IND"); india.setCity("Mumbai"); teams.save(india);
            Team australia = new Team(); australia.setName("Australia"); australia.setShortName("AUS"); australia.setCity("Sydney"); teams.save(australia);

            Player rohit = player("Rohit Sharma", "Batsman", "Right Hand", "Off Break", india, players);
            Player virat = player("Virat Kohli", "Batsman", "Right Hand", "Right Arm Medium", india, players);
            player("KL Rahul", "Wicket Keeper", "Right Hand", "None", india, players);
            player("Jasprit Bumrah", "Bowler", "Right Hand", "Right Arm Fast", india, players);
            player("David Warner", "Batsman", "Left Hand", "Right Arm Medium", australia, players);
            player("Steve Smith", "Batsman", "Right Hand", "Leg Break", australia, players);
            player("Mitchell Marsh", "All Rounder", "Right Hand", "Right Arm Medium", australia, players);
            Player starc = player("Mitchell Starc", "Bowler", "Left Hand", "Left Arm Fast", australia, players);

            Match match = new Match();
            match.setTeam1(india); match.setTeam2(australia);
            match.setVenue("Wankhede Stadium, Mumbai"); match.setFormat("T20"); match.setStatus("LIVE");
            match.setMatchDate(LocalDateTime.now()); match.setCurrentBattingTeam(india); match.setCurrentBowlingTeam(australia);
            match.setCurrentStriker(rohit); match.setCurrentNonStriker(virat); match.setCurrentBowler(starc);
            matches.save(match);

            Score s1 = new Score(); s1.setMatch(match); s1.setTeam(india); s1.setRuns(84); s1.setWickets(2); s1.setBalls(62); scores.save(s1);
            Score s2 = new Score(); s2.setMatch(match); s2.setTeam(australia); s2.setRuns(0); s2.setWickets(0); s2.setBalls(0); scores.save(s2);
        };
    }

    private Player player(String name, String role, String bat, String bowl, Team team, PlayerRepository repo) {
        Player p = new Player(); p.setName(name); p.setRole(role); p.setBattingStyle(bat); p.setBowlingStyle(bowl); p.setTeam(team); return repo.save(p);
    }
}
