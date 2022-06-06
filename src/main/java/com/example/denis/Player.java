package com.example.denis;

import lombok.Data;

@Data
public class Player implements Comparable<Player> {

    private int Id;
    private static int playerCounter = 0;
    int numberOfTries = 0;
    int numberOfWins = 0;

    public Player() {

        this.Id = playerCounter ++;

    }

    public Player(int numberOfTries, int numberOfWins) {
        this.numberOfTries = numberOfTries;
        this.numberOfWins = numberOfWins;
    }

    @Override
    public int compareTo(Player o) {

        int compareage = ((Player)o).getNumberOfWins();

        return compareage- this.numberOfWins;

    }


}
