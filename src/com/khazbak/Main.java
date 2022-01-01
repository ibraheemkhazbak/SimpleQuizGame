package com.khazbak;

import com.khazbak.player.Player;
import com.khazbak.player.PlayerDomain;

import java.io.IOException;
import java.security.spec.ECField;

public class Main {
    public static void main(String[] args)  {
        PlayerDomain playerDomain=new PlayerDomain(5);
        Player player;

        if(args.length>0){
            if(args[0].equals("--help")){
                System.out.println("QuizGame <lives> <questions>");
            }else{
                try{
                    playerDomain=new PlayerDomain(Integer.parseInt(args[1]));
                     player = new Player(playerDomain, Integer.parseInt(args[0]));
                    playerDomain.askAllQuestions(player.getID());
                }catch (Exception e){
                    System.out.println("Invalid use of this command use --help to know how to use the command");

                }
            }
        }else{
            player = new Player(playerDomain,3);
            System.out.println(player.getID());
            playerDomain.askAllQuestions(player.getID());

        }



    }

}
