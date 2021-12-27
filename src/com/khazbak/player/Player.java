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
    private int questionsGotRight, questionsGotWrong;
    private AnswerHandler answerHandler;

    public Player(String name, int maxLives, int numberOfQuestions) {
        this.name = name;
        this.maxLives = maxLives;


        lives = maxLives;
        answerHandler = new AnswerHandler();
        questions = new ArrayList<>();
        generator = new QuestionGenerator(numberOfQuestions, questions);
    }


    public void loseLife() {
        lives--;
    }

    public Question getCurrentQuestion() {
        return questions.get(currentQuestionIndex);
    }

    public void ask() {

        int length = questions.size();
        while (currentQuestionIndex < length) {
            Renderer.renderQuestion(this);
            if (answerHandler.getAnswer(this)) {
                questionsGotRight++;
            } else {
                questionsGotWrong++;
            }
            currentQuestionIndex++;
            if (currentQuestionIndex != length) {
                System.out.println("Moving on to the next question");
            }
            lives = maxLives;
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

    public int getQuestionsGotRight() {
        return questionsGotRight;
    }

    public int getQuestionsGotWrong() {
        return questionsGotWrong;
    }

    public String getName() {
        return name;
    }

    public int getLives() {
        return lives;
    }

}
