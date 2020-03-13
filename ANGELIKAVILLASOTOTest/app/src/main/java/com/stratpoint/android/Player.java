package com.stratpoint.android;

import java.util.Comparator;

public class Player {
    private String player_name;
    private String score;

    public Player(String player_name, String score) {
        this.player_name = player_name;
        this.score = score;
    }

    public String getPlayer_name() {
        return player_name;
    }

    public String getScore() {
        return score;
    }
}
