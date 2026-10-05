package com.example.cricketscore.repository;
import com.example.cricketscore.model.Score;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;
public interface ScoreRepository extends JpaRepository<Score,Long> { List<Score> findByMatchId(Long matchId); Optional<Score> findByMatchIdAndTeamId(Long matchId,Long teamId); }
