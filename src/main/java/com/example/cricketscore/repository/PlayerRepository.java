package com.example.cricketscore.repository;
import com.example.cricketscore.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface PlayerRepository extends JpaRepository<Player,Long> { List<Player> findByTeamId(Long teamId); }
