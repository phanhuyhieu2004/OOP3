package com.example.client;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainClient extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainServer.class.getResource("sev.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 500);
        primaryStage.setTitle("Client!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
