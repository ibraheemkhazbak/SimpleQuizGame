package com.khazbak.question;

import com.khazbak.Delay;
import com.khazbak.player.Player;
import com.khazbak.player.PlayerDomain;

import java.util.Scanner;

public class AnswerHandler {
    Scanner scan = new Scanner(System.in);

    public boolean getPlayerAnswer(PlayerDomain playerDomain,int playerIndex) {

        Player player= playerDomain.players.get(playerIndex);
        int ANSWER = -1;
        while (player.getLives() > 0) {
            try {
                ANSWER= getPlayerAnswer();
                if (playerDomain.getCurrentQuestion().isAnswerCorrect(ANSWER)) {
                    return true;
                }
            } catch (Exception e) {
                scan.nextLine();
            }

            player.loseLife();
            System.out.println("You have "+player.getLivesToString());
         Delay.wait(1000);

        }
        return false;
    }
   public int getPlayerAnswer(){
        int answer;
        answer = scan.nextInt();
        scan.nextLine();
        return answer;
    }
}
