package com.example.quizpio;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;

import java.util.ArrayList;

public class Controller {
    private int currentQue = 0;
    private int correctAns = 0;
    private String selectedText;
    private QuestionBase questionBase = new QuestionBase("src/main/exampleQuiz");
    @FXML
    private Label Question;
    @FXML
    private RadioButton btnAnswer1;
    @FXML
    private RadioButton btnAnswer2;
    @FXML
    private RadioButton btnAnswer3;
    @FXML
    private RadioButton btnAnswer4;
    @FXML
    private Button btnNext;
    @FXML
    private Button btnResults;

    public void initialize(){
        Question.setText(questionBase.getQuestion(currentQue).getW());
        setAnswers();

        /*btnAnswer1.setText(questionBase.getQuestion(currentQue).getAnswers()[0]);
        btnAnswer2.setText(questionBase.getQuestion(currentQue).getAnswers()[1]);
        btnAnswer3.setText(questionBase.getQuestion(currentQue).getAnswers()[2]);
        btnAnswer4.setText(questionBase.getQuestion(currentQue).getAnswers()[3]);*/

        ToggleGroup toggleGroup = new ToggleGroup();
        btnAnswer1.setToggleGroup(toggleGroup);
        btnAnswer2.setToggleGroup(toggleGroup);
        btnAnswer3.setToggleGroup(toggleGroup);
        btnAnswer4.setToggleGroup(toggleGroup);

        toggleGroup.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                RadioButton selectedRadioButton = (RadioButton) newValue;
                selectedText = selectedRadioButton.getText();
            }
        });
    }

    @FXML
    protected void btnNextClicked() {
        if (selectedText.equals(questionBase.getQuestion(currentQue).getAnswers()[0])){
            correctAns++;
        }

        currentQue++;
        Question.setText(questionBase.getQuestion(currentQue).getW());
        /*btnAnswer1.setText(questionBase.getQuestion(currentQue).getAnswers()[0]);
        btnAnswer2.setText(questionBase.getQuestion(currentQue).getAnswers()[1]);
        btnAnswer3.setText(questionBase.getQuestion(currentQue).getAnswers()[2]);
        btnAnswer4.setText(questionBase.getQuestion(currentQue).getAnswers()[3]);*/
        setAnswers();

        if (questionBase.getSize() == currentQue + 1){
            btnNext.setVisible(false);
        }

        btnAnswer1.setSelected(false);
        btnAnswer2.setSelected(false);
        btnAnswer3.setSelected(false);
        btnAnswer4.setSelected(false);
    }

    @FXML
    protected void btnResultsClicked() {
        if (selectedText.equals(questionBase.getQuestion(currentQue).getAnswers()[0])){
            correctAns++;
        }

        btnNext.setVisible(false);
        btnResults.setVisible(false);
        btnAnswer1.setVisible(false);
        btnAnswer2.setVisible(false);
        btnAnswer3.setVisible(false);
        btnAnswer4.setVisible(false);

        AnchorPane.setTopAnchor(Question, 200.0);
        AnchorPane.setLeftAnchor(Question, 100.0);

        Question.setText("Gratulacje, twój wynik to: " + correctAns + " na " + questionBase.getSize() + " punktów!");
    }

    private void setAnswers(){
        ArrayList<String> AnwersList = new ArrayList<>();
        AnwersList.add(questionBase.getQuestion(currentQue).getAnswers()[0]);
        AnwersList.add(questionBase.getQuestion(currentQue).getAnswers()[1]);
        AnwersList.add(questionBase.getQuestion(currentQue).getAnswers()[2]);
        AnwersList.add(questionBase.getQuestion(currentQue).getAnswers()[3]);
        int a;
        a = (int) (Math.random() * (AnwersList.size()));
        btnAnswer1.setText(AnwersList.get(a));
        AnwersList.remove(a);
        a = (int) (Math.random() * (AnwersList.size()));
        btnAnswer2.setText(AnwersList.get(a));
        AnwersList.remove(a);
        a = (int) (Math.random() * (AnwersList.size()));
        btnAnswer3.setText(AnwersList.get(a));
        AnwersList.remove(a);
        a = (int) (Math.random() * (AnwersList.size()));
        btnAnswer4.setText(AnwersList.get(a));
        AnwersList.remove(a);
    }
}