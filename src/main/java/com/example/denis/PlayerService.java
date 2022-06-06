package com.example.denis;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

@Service
public class PlayerService {

    public int start() {

        Player player = new Player();

        PlayerDb.playerList.add(player);

        return player.getId();

    }


    public HashMap<String, String> quess(String number, String session) {

        HashMap<String,String> result = new HashMap<>();
        int random = (int) ((Math.random() * (100 - 1)) + 1);
        int attempt = Integer.parseInt(number);
        int tries = PlayerDb.playerList.get(Integer.parseInt(session)).getNumberOfTries();

        PlayerDb.playerList.get(Integer.parseInt(session)).setNumberOfTries(tries +1);

        result.put("Session Id: ", session);
        result.put("Number of tries: ", String.valueOf(tries+1));

        if(attempt == random){

            PlayerDb.playerList.get(Integer.parseInt(session)).setNumberOfWins(+1);
            result.put("Result: ", "Win ");

        }else if (attempt > random ){

            result.put("Result: ", " too big");

        }else{

            result.put("Result: ", " to small");
        }


        return result;


    }


    public List<Player> highscores() {

        List<Player> highscore = PlayerDb.playerList;
        Collections.sort(highscore);
        List<Player> result = new ArrayList<>();

        int i = 0;
        for(Player x : highscore){

            i++;
            result.add(x);

            if(i == 10){
                break;
            }
        }

        return result;

    }
}
