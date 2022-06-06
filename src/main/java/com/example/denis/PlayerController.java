package com.example.denis;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.List;

@RestController
@AllArgsConstructor
public class PlayerController {


    private PlayerService playerService;

    @GetMapping(path = "/start")
    int start(){

        return playerService.start();

    }

    @PostMapping(path = "/quess")
    HashMap<String , String > quess(@RequestBody HashMap<String,String> json){


        return playerService.quess(json.get("number"), json.get("session"));

    }

    @GetMapping(path = "/highscores")
    List<Player> highscores(){

        return playerService.highscores();

    }


}
