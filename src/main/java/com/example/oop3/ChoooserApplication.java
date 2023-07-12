package com.example.oop3;

import javafx.application.Application;
import javafx.stage.Stage;


import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class ChoooserApplication extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("chooser.fxml"));
        AnchorPane root = loader.load();

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Xem ảnh");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

