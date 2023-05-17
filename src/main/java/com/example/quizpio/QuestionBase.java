/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.quizpio;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 *
 * @author Tomek
 */
public class QuestionBase {

    private ArrayList<Question> list;

    private ArrayList<Question> randomQuestions;
    public QuestionBase() {
        list = new ArrayList<>();
    }

    public QuestionBase(String filename) {
        list = new ArrayList<>();
        randomQuestions = new ArrayList<>();
        try {
            FileInputStream fileInputStream = new FileInputStream(filename);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            int flag = 0;
            String w;
            while ((w = bufferedReader.readLine()) != null) {
                Question q = new Question();
                String[] answers = new String[4];
                for (int i = 0; i < 4; i++) {
                    if ((answers[i] = bufferedReader.readLine()) == null) {
                        System.out.println("Błąd w czytaniu pytań");
                        flag = 1;
                        break;
                    }
                }
                if (flag == 1) {
                    break;
                }

                q.setW(w);
                q.setAnswers(answers);
                list.add(q);
            }
            System.out.println("Odczytana Liczba pytan: " + list.size());
            // Close the input streams
            bufferedReader.close();
            inputStreamReader.close();
            fileInputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Question getQuestion(int k) {
        return list.get(k);
    }

    public void addtoQuestionBase(Question q) {
        list.add(q);
    }

    public int getSize() {
        return list.size();
    }

    public boolean isEqual(int n, int[] x){
        for (int i = 0; i < x.length; i++){
            if(n == x[i]){
                return true;
            }
        }
        return false;
    }
    public void drawQuestions(){
        int numOfQuestions = list.size();
        int randomIndex = 0;
        int temp[] = new int[5];
        for (int i = 0; i < 5; i++){
            while (isEqual(randomIndex, temp)) {
                randomIndex = (int) (Math.random() * numOfQuestions);
            }
            temp[i] = randomIndex;
            randomQuestions.add(list.get(randomIndex));
        }
    }

    public void printQuestionBase() {
        for (int i = 0; i < randomQuestions.size(); i++) {
            System.out.println("question " + (i + 1) + ": " + randomQuestions.get(i).getW());
            String[] ans = randomQuestions.get(i).getAnswers();
            for (int j = 0; j < 4; j++) {
                System.out.println("answer " + (j + 1) + ": " + ans[j]);
            }
        }
    }

    public static void main(String s[]) {
        QuestionBase q = new QuestionBase("src/main/exampleQuiz");
        q.drawQuestions();
        q.printQuestionBase();
    }

}
