package com.example.oop3.cs;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainServer extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("server.fxml"));

        Scene scene = new Scene(root, 500, 450);
        scene.getStylesheets().add(getClass().getResource("server.css").toExternalForm());

        primaryStage.setTitle("Message Server");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
