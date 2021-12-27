package com.khazbak;

import com.khazbak.player.Player;
import com.khazbak.question.QuestionGenerator;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Player player = new Player("Khazbak", 3, 3);
        player.ask();


    }

}
