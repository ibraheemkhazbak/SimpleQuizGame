package com.khazbak;

import com.khazbak.player.Player;
import com.khazbak.player.PlayerDomain;
import com.khazbak.question.Question;
import org.w3c.dom.ls.LSOutput;

import java.io.IOException;

public class Renderer {
    public static void renderQuestion(Player player) {
        refreshScreen();
        Question question = player.getPlayerDomain().getCurrentQuestion();
        System.out.println(" Question number " + question.getId() + " and you have " + player.getLivesToString());
        System.out.println(question);
    }

    public static void refreshScreen() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

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
        System.out.println((int)(player.getQuestionsGotRight()*100 / player.getPlayerDomain().getQuestions().size())+"%");
    }
}
