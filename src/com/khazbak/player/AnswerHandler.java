package com.khazbak.player;

import java.util.Scanner;

public class AnswerHandler {
    Scanner scan = new Scanner(System.in);

    public boolean getAnswer(Player player) {
        int answer = -1;
        while (player.getLives() > 0) {
            try {
                answer=getAnswer();
                if (player.getCurrentQuestion().isAnswerCorrect(answer)) {
                    return true;
                }
            } catch (Exception e) {
                scan.nextLine();
            }
            player.loseLife();
            System.out.println("You have "+player.getLivesToString());

        }
        return false;
    }
    public int  getAnswer(){
        int answer;
        answer = scan.nextInt();
        scan.nextLine();
        return answer;
    }
}
