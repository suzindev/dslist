package com.suzintech.dslist.repositories;

import com.suzintech.dslist.entities.GameList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface GameListRepository extends JpaRepository<GameList, Long> {

    @Modifying
    @Query(nativeQuery = true,
            value = "UPDATE tb_beloging SET position = :newPosition WHERE list_id = :listId AND game_id = :gameId")
    void updateBelogingPosition(Long listId, Long gameId, Integer newPosition);
}
