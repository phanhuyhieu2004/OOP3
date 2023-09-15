package com.example.oop3;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class JavafxSample extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        // Creating an AnchorPane object
        AnchorPane anchorPane = new AnchorPane();

        // Creating a Scene by passing the anchorPane object, height, and width
        Scene scene = new Scene(anchorPane, 600, 300);

        // Setting color to the scene
        scene.setFill(Color.BROWN);

        // Setting the title to Stage.
        primaryStage.setTitle("Sample Application");

        // Adding the scene to Stage
        primaryStage.setScene(scene);

        // Displaying the contents of the stage
        primaryStage.show();
    }

    public static void main(String args[]) {
        launch(args);
    }
}