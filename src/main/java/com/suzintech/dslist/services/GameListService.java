package com.suzintech.dslist.services;

import com.suzintech.dslist.dto.GameListDTO;
import com.suzintech.dslist.entities.GameList;
import com.suzintech.dslist.repositories.GameListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {

    @Autowired
    private GameListRepository gameListRepository;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll() {
        List<GameList> result = gameListRepository.findAll();

        return result.stream()
                .map(GameListDTO::new)
                .toList();
    }
}
