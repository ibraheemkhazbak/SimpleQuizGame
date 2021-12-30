package com.khazbak.question;

import java.util.List;
import java.util.Random;

public class QuestionGenerator {
    int amountOfQuestions;
    public static final char[] operators = {'+', '-'};
    private List<Question> questions;

    public QuestionGenerator(int amountOfQuestions, List<Question> questions) {
        this.amountOfQuestions = amountOfQuestions;
        this.questions=questions;
    }
    public void generateAllQuestions(){
        for (int i = 0; i < amountOfQuestions; i++) {
            generateRandomQuestion(i + 1, questions);
        }
    }

    //generates a random question
    private void generateRandomQuestion(int id, List<Question> questions) {

        int firstNumber = generateRandomNumber(0, 10);
        int secondNumber = generateRandomNumber(0, 10);
        char operator = operators[generateRandomNumber(0, operators.length - 1)];

        questions.add(new Question(id, firstNumber, secondNumber, operator));

    }

    //generate a random number in range
    private int generateRandomNumber(int min, int max) {
        return (int) Math.floor(Math.random() * (max - min + 1) + min);
    }

}
