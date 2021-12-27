package com.khazbak;

import com.khazbak.player.Player;
import com.khazbak.question.Question;
import org.w3c.dom.ls.LSOutput;

public class Renderer {
    public static void renderQuestion(Player player) {
        refreshScreen();
        Question question = player.getCurrentQuestion();
        System.out.println(player.getName() + " Question number " + question.getId() + " and you have " + player.getLives() + " lives");
        System.out.println(question);
    }

    public static void refreshScreen() {
        System.out.println("\033[H\033[2J ");
    }

    public static void renderFailScreen(Player player) {
        refreshScreen();
        System.out.println("YOU FAILED... GAME OVER");
        renderResult(player);
    }

    public static void renderWinScreen(Player player) {
        refreshScreen();
        System.out.println("You won! congratulations");
        renderResult(player);
    }

    public static void renderResult(Player player) {
        System.out.println(player.getQuestionsGotRight() / player.getQuestions().size());
    }
}
