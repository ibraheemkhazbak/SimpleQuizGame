package com.khazbak;

import com.khazbak.player.Player;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Player player = new Player("Khazbak", 1, 3);
        player.askAllQuestions();


    }

}
