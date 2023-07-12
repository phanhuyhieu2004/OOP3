package com.example.oop3;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

public class QuizController {

    @FXML
    private ToggleGroup question1Group;
    @FXML
    private ToggleGroup question2Group;
    @FXML
    private Label question1Result;
    @FXML
    private Label question2Result;
    @FXML
    private Label quizSummary;

    @FXML
    private void submitQuiz() {
        int numCorrect = 0;
        // Kiểm tra đáp án câu hỏi 1
        RadioButton selectedQuestion1 = (RadioButton) question1Group.getSelectedToggle();
        if (selectedQuestion1 != null && selectedQuestion1.getId().equals("question1OptionA")) {
            question1Result.setText("Câu hỏi 1: Đúng");
            numCorrect++;
        } else {
            question1Result.setText("Câu hỏi 1: Sai");
        }

        // Kiểm tra đáp án câu hỏi 2
        RadioButton selectedQuestion2 = (RadioButton) question2Group.getSelectedToggle();
        if (selectedQuestion2 != null && selectedQuestion2.getId().equals("question2OptionC")) {
            question2Result.setText("Câu hỏi 2: Đúng");
            numCorrect++;
        } else {
            question2Result.setText("Câu hỏi 2: Sai");
        }

        // Hiển thị kết quả tổng kết
        quizSummary.setText("Bạn đã trả lời đúng " + numCorrect + " câu hỏi trên tổng số 2 câu hỏi.");
    }
}