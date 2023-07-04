package com.suzintech.dslist.services;

import com.suzintech.dslist.dto.GameDTO;
import com.suzintech.dslist.dto.GameMinDTO;
import com.suzintech.dslist.entities.Game;
import com.suzintech.dslist.projections.GameMinProjection;
import com.suzintech.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public GameDTO findById(Long id) {
        Game result = gameRepository.findById(id).get();

        return new GameDTO(result);
    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll() {
        List<Game> result = gameRepository.findAll();

        return result.stream()
                .map(GameMinDTO::new)
                .toList();
    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> findByList(Long listId) {
        List<GameMinProjection> result = gameRepository.searchByList(listId);

        return result.stream()
                .map(GameMinDTO::new)
                .toList();
    }
}
