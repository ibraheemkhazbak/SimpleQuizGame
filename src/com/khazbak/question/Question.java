package com.khazbak.question;

import java.util.ArrayList;

public class Question {
    private int id, firstNumber, secondNumber;
    private char operator;

    public Question(int id, int firstNumber, int secondNumber, char operator) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
        this.operator = operator;
        this.id = id;

    }

    public boolean isAnswerCorrect(int answer) {
        return answer == getAnswer();
    }

    private int getAnswer() {
        if (operator == '+') {
            return firstNumber + secondNumber;
        } else if (operator == '-') {
            return firstNumber - secondNumber;
        }
        return -1;
    }


    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return firstNumber + "\n"
                + operator + "\n"
                + secondNumber + "\n"
                + "-------------";
    }
}
