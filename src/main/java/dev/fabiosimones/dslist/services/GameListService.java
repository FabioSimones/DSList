package dev.fabiosimones.dslist.services;

import dev.fabiosimones.dslist.dto.GameDTO;
import dev.fabiosimones.dslist.dto.GameListDTO;
import dev.fabiosimones.dslist.dto.GameMinDTO;
import dev.fabiosimones.dslist.entities.Game;
import dev.fabiosimones.dslist.entities.GameList;
import dev.fabiosimones.dslist.repositories.GameListRepository;
import dev.fabiosimones.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {

    @Autowired
    private GameListRepository gameListRepository;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll(){
        List<GameList> result = gameListRepository.findAll();
        return result.stream().map(x -> new GameListDTO(x)).toList();
    }
}
