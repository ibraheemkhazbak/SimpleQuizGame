package com.khazbak;

import com.khazbak.player.Player;

import java.io.IOException;
import java.security.spec.ECField;

public class Main {
    public static void main(String[] args)  {
        Player player;
        if(args.length>0){
            if(args[0].equals("--help")){
                System.out.println("QuizGame <Name> <lives> <questions>");
            }else{
                try{
                    System.out.println(args[0]+args[1]);
                     player = new Player(args[0], Integer.parseInt(args[1]), Integer.parseInt(args[2]));
                    player.askAllQuestions();
                }catch (Exception e){
                    System.out.println("Invalid use of this command use --help to know how to use the command");

                }
            }
        }else{
            player = new Player("Khazbak", 3, 10);
            player.askAllQuestions();

        }



    }

}
