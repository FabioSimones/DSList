package dev.fabiosimones.dslist.repositories;

import dev.fabiosimones.dslist.entities.GameList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameListRepository extends JpaRepository<GameList, Long> {
}
