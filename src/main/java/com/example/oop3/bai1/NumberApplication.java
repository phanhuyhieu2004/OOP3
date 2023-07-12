package com.example.oop3.bai1;

import javafx.application.Application;
import javafx.stage.Stage;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;

public class NumberApplication extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        AnchorPane root = FXMLLoader.load(getClass().getResource("number.fxml"));
        Scene scene = new Scene(root, 600, 200);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Game Đoán số"
                );
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
