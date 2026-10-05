package com.example.cricketscore.repository;
import com.example.cricketscore.model.Match;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface MatchRepository extends JpaRepository<Match,Long> { List<Match> findByStatusIgnoreCase(String status); }
