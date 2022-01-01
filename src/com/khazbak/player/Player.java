package com.khazbak.player;

import com.khazbak.Renderer;
import com.khazbak.question.AnswerHandler;
import com.khazbak.question.Question;
import com.khazbak.question.QuestionGenerator;

import java.util.ArrayList;

public class Player {
    private int ID;
    private QuestionGenerator generator;
    private int lives, maxLives;
    private PlayerDomain playerDomain;
    private double questionsGotRight;
    private AnswerHandler answerHandler;

    public Player(PlayerDomain playerDomain,int maxLives) {
        this.playerDomain=playerDomain;
        this.maxLives = maxLives;
        lives = maxLives;
        playerDomain.players.add(this);
        ID=playerDomain.players.size()-1;
    }


    public void loseLife() {
        lives--;
    }
public void resetLives(){
        lives=maxLives;
}
public void addScorePoint(){
        questionsGotRight++;
}




    public double getQuestionsGotRight() {
        return questionsGotRight;
    }

    public int getLives() {
        return lives;
    }

    public String getLivesToString() {
        String livesString = String.valueOf(lives);
    if(lives>1){
        livesString += " lives";

    }else if(lives==1){
        livesString += " life";
    }else if(lives==0){
        livesString +=" lives and you lost a point";
    }
    return livesString;
    }
    public boolean hasFailed(){
        return questionsGotRight/playerDomain.numberOfQuestions<0.5;
    }

    public int getID() {
        return ID;
    }

    public PlayerDomain getPlayerDomain() {
        return playerDomain;
    }
}
