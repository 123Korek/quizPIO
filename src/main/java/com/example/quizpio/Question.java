/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.quizpio;

/**
 *
 * @author Tomek
 */
public class Question {

    private String w;
    private String[] answers;

    public Question() {
        w = new String();
        answers = new String[4];
    }

    public void setW(String w) {
        this.w = w;
    }

    public void setAnswers(String[] answers) {
        this.answers = answers;
    }

    public String getW() {
        return w;
    }

    public String[] getAnswers() {
        return answers;
    }

    public void printQuestion() {
        System.out.println("question: " + w);
        for (int j = 0; j < 4; j++) {
            System.out.println("answer " + (j + 1) + ": " + answers[j]);
        }
    }

}
