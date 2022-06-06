package com.example.denis;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class PlayerServiceTest {

    @InjectMocks
    private PlayerService service;



    @Test
    void startPlayerAdded() {

        int id = service.start();
        int addedPlayerId = PlayerDb.playerList.get(PlayerDb.playerList.size()-1).getId();
        assertEquals(id, addedPlayerId);

    }

    @Test
    void quess() {

        int id = service.start();

        int dbSize = PlayerDb.playerList.size();
        service.quess("8",String.valueOf(id));

        Assertions.assertEquals(PlayerDb.playerList.get(dbSize -1 ).numberOfTries, 1);


    }

    @Test
    void highscores(){

        PlayerDb.playerList.add(new Player(2,1000));

        Player player = service.highscores().get(0);

        assertEquals(1000, player.numberOfWins);

    }
}