package com.example.oop3;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

public class QuizController {

    @FXML
    private Label question1Label;

    @FXML
    private Label question2Label;

    @FXML
    private Label question3Label;


    @FXML
    private RadioButton answer1Option1;

    @FXML
    private RadioButton answer1Option2;

    @FXML
    private RadioButton answer1Option3;

    @FXML
    private RadioButton answer2Option1;

    @FXML
    private RadioButton answer2Option2;

    @FXML
    private RadioButton answer2Option3;

    @FXML
    private RadioButton answer3Option1;

    @FXML
    private RadioButton answer3Option2;

    @FXML
    private RadioButton answer3Option3;

    @FXML
    private Button submitButton;

    @FXML
    private Label result1Label;

    @FXML
    private Label result2Label;

    @FXML
    private Label result3Label;

    private ToggleGroup answer1Group;
    private ToggleGroup answer2Group;
    private ToggleGroup answer3Group;

    public void initialize() {
        answer1Group = new ToggleGroup();
        answer1Option1.setToggleGroup(answer1Group);
        answer1Option2.setToggleGroup(answer1Group);
        answer1Option3.setToggleGroup(answer1Group);

        answer2Group = new ToggleGroup();
        answer2Option1.setToggleGroup(answer2Group);
        answer2Option2.setToggleGroup(answer2Group);
        answer2Option3.setToggleGroup(answer2Group);

        answer3Group = new ToggleGroup();
        answer3Option1.setToggleGroup(answer3Group);
        answer3Option2.setToggleGroup(answer3Group);
        answer3Option3.setToggleGroup(answer3Group);

        submitButton.setOnAction(event -> checkAnswers());
    }

    private void checkAnswers() {
        String result1 = checkAnswer(answer1Group, answer1Option2);
        String result2 = checkAnswer(answer2Group, answer2Option1);
        String result3 = checkAnswer(answer3Group, answer3Option3);

        result1Label.setText("Câu 1: " + result1);
        result2Label.setText("Câu 2: " + result2);
        result3Label.setText("Câu 3: " + result3);
    }

    private String checkAnswer(ToggleGroup group, RadioButton correctOption) {
        RadioButton selectedOption = (RadioButton) group.getSelectedToggle();

        if (selectedOption != null) {
            if (selectedOption == correctOption) {
                return "Đúng";
            } else {
                return "Sai";
            }
        }

        return "Chưa chọn";
    }
}
