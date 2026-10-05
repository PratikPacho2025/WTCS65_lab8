package com.example.cricketscore.repository;
import com.example.cricketscore.model.MatchEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface MatchEventRepository extends JpaRepository<MatchEvent,Long> { List<MatchEvent> findByMatchIdOrderByIdDesc(Long matchId); }
