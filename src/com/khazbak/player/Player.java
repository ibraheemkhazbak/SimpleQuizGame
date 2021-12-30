package com.khazbak.player;

import com.khazbak.Renderer;
import com.khazbak.question.Question;
import com.khazbak.question.QuestionGenerator;

import java.util.ArrayList;

public class Player {
    private String name;
    private ArrayList<Question> questions;
    private QuestionGenerator generator;
    private int lives, maxLives;
    private int currentQuestionIndex = 0;
    private double questionsGotRight, questionsGotWrong;
    private AnswerHandler answerHandler;

    public Player(String name, int maxLives, int numberOfQuestions) {
        this.name = name;
        this.maxLives = maxLives;


        lives = maxLives;
        answerHandler = new AnswerHandler();
        questions = new ArrayList<>(numberOfQuestions);
        generator = new QuestionGenerator(numberOfQuestions, questions);
        generator.generateAllQuestions();
    }


    public void loseLife() {
        lives--;
    }

    public Question getCurrentQuestion() {
        return questions.get(currentQuestionIndex);
    }
    public void ask(){
        Renderer.renderQuestion(this);
        if (answerHandler.getAnswer(this)) {
            questionsGotRight++;
        } else {
            questionsGotWrong++;
        }

        lives = maxLives;
    }

    public void askAllQuestions() {

        int length = questions.size();
        while (currentQuestionIndex < length) {
             ask();
            if (currentQuestionIndex != length) {
                System.out.println("Moving on to the next question");
                currentQuestionIndex++;
            }
        }
        if (questionsGotRight / length < 0.5) {
            Renderer.renderFailScreen(this);
        } else {
            Renderer.renderWinScreen(this);
        }


    }

    public ArrayList<Question> getQuestions() {
        return questions;
    }

    public double getQuestionsGotRight() {
        return questionsGotRight;
    }

    public String getName() {
        return name;
    }

    public int getLives() {
        return lives;
    }

    public String getLivesToString() {
        String livesString = String.valueOf(lives);
    if(lives>1){
        livesString +=" lives";
    }else if(lives==1){
        livesString += " life";
    }else if(lives==0){
        livesString +=" lives and you lost a point";
    }
    return livesString;
    }
}
