package dev.fabiosimones.dslist.repositories;

import dev.fabiosimones.dslist.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {
}
