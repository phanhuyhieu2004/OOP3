package bai5;

import javafx.application.Application;
import javafx.stage.Stage;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.*;

public class ChatApp extends Application {

    private DatagramSocket socket;
    private InetAddress serverAddress;
    private int serverPort;
    private ListView<String> messageListView;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("CHAT App");

        TextField chatTextField = new TextField();
        Button sendButton = new Button("Send");
        Button connectButton = new Button("Connect");
        connectButton.setDisable(true);

        messageListView = new ListView<>();
        messageListView.setPrefHeight(300);

        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(10));
        vbox.getChildren().addAll(chatTextField, sendButton, connectButton, messageListView);

        Scene scene = new Scene(vbox, 300, 400);
        primaryStage.setScene(scene);

        // Set up UDP socket
        try {
            socket = new DatagramSocket();
        } catch (SocketException e) {
            e.printStackTrace();
        }

        // Event handler for "Connect" button
        connectButton.setOnAction(event -> {
            try {
                serverAddress = InetAddress.getByName("localhost");
                serverPort = 8080;
                connectButton.setDisable(true);

                startReceiving();
            } catch (UnknownHostException e) {
                e.printStackTrace();
            }
        });

        // Event handler for "Send" button
        sendButton.setOnAction(event -> {
            String message = chatTextField.getText();
            send(message);
            chatTextField.clear();
        });

        primaryStage.show();
    }

    private void startReceiving() {
        Thread receiveThread = new Thread(() -> {
            byte[] buffer = new byte[1024];

            while (true) {
                try {
                    DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                    socket.receive(packet);
                    String message = new String(packet.getData(), 0, packet.getLength());

                    Platform.runLater(() -> messageListView.getItems().add(message));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        receiveThread.setDaemon(true);
        receiveThread.start();
    }

    private void send(String message) {
        byte[] data = message.getBytes();
        DatagramPacket packet = new DatagramPacket(data, data.length, serverAddress, serverPort);

        try {
            socket.send(packet);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}




