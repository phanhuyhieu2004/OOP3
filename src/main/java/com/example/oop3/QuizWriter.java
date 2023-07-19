package com.example.oop3;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class QuizWriter {
    public static void main(String[] args) throws IOException {
        String fileName = "quiz.txt";

        try {
            // Create a PrintWriter object to write to the file
            PrintWriter writer = new PrintWriter(new FileWriter(fileName));

            // Write quiz questions and answers to the file
            String quizInfo = "Quiz Info:\n";
            quizInfo += "Question 1: 2 + 2 = ?\n";
            quizInfo += "A. 3\n";
            quizInfo += "B. 4\n";
            quizInfo += "C. 5\n";
            writer.println(quizInfo);

            writer.close();
            System.out.println("Quiz info has been saved to " + fileName);
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
    }
}