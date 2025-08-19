package dev.fabiosimones.dslist.controllers;

import dev.fabiosimones.dslist.dto.GameDTO;
import dev.fabiosimones.dslist.dto.GameListDTO;
import dev.fabiosimones.dslist.dto.GameMinDTO;
import dev.fabiosimones.dslist.services.GameListService;
import dev.fabiosimones.dslist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {

    @Autowired
    private GameListService gameListService;

    @GetMapping
    public List<GameListDTO> findAll(){
        return gameListService.findAll();
    }
}
