package com.khazbak.player;

import com.khazbak.Delay;
import com.khazbak.Renderer;
import com.khazbak.question.AnswerHandler;
import com.khazbak.question.Question;
import com.khazbak.question.QuestionGenerator;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class PlayerDomain {
    public   ArrayList<Player> players=new ArrayList<>();
    public   ArrayList<Question> questions=new ArrayList<>();
    public   AnswerHandler answerHandler=new AnswerHandler();;
    public   int numberOfQuestions;
    private    int currentQuestion = 0;
    public   QuestionGenerator generator;

    public PlayerDomain(int numberOfQuestions) {
        this.numberOfQuestions = numberOfQuestions;
        generator=new QuestionGenerator(numberOfQuestions, questions);
        generator.generateAllQuestions();
    }

    public   void askAllQuestions(int playerID) {
Player playerSelected=players.get(playerID);
        int length = questions.size();
        while (currentQuestion < length) {
            ask(playerID);
            if (currentQuestion != length-1) {
                System.out.println("Moving on to the next question");
            }
            Delay.wait(1000);
            currentQuestion++;
        }
        if (playerSelected.hasFailed()) {
            Renderer.renderFailScreen(playerSelected);
        } else {
            Renderer.renderWinScreen(playerSelected);
        }


    }
    public   void ask(int playerID){
        Player playerSelected=players.get(playerID);
        Renderer.renderQuestion(players.get(playerID));
        if (answerHandler.getPlayerAnswer(this,playerID)) {
            playerSelected.addScorePoint();
        }

        playerSelected.resetLives();
    }
    public    Question getCurrentQuestion() {
        return questions.get(currentQuestion);
    }

    public ArrayList<Question> getQuestions() {
    return questions;
    }
}
