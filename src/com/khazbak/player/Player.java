package com.khazbak.player;


public class Player {
    private final int ID;
    private final int maxLives;
    private final PlayerDomain playerDomain;
    private int lives;
    private double questionsGotRight;

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
        return (int)(questionsGotRight*100 / playerDomain.numberOfQuestions)<50;
    }

    public int getID() {
        return ID;
    }

    public PlayerDomain getPlayerDomain() {
        return playerDomain;
    }
}
