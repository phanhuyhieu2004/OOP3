package com.example.client;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainServer extends Application {
        @Override
        public void start(Stage stage) throws IOException, IOException {
            FXMLLoader fxmlLoader = new FXMLLoader(MainServer.class.getResource("server.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 600, 500);
            stage.setTitle("Server!");
            stage.setScene(scene);
            stage.show();
        }

        public static void main(String[] args) {
            launch();
        }


}

