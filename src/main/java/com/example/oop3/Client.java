package com.example.oop3.cs;

import javafx.scene.layout.VBox;

import java.io.*;
import java.net.Socket;

public class Client {

    private Socket socket;
    private PrintWriter writer;
    private BufferedReader reader;

    public Client(Socket socket) throws IOException {
        try {
            this.socket = socket;
            this.reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.writer = new PrintWriter(socket.getOutputStream(), true);
        } catch (IOException e) {
            System.out.println("Lỗi khi tạo máy khách");
            e.printStackTrace();
            closeAll();
        }

    }

    public void sendMessageToServer(String messageToServer) {
        writer.println(messageToServer);

    }

    public void recieveMessageFromServer(VBox vBox) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (socket.isConnected()) {
                    try {
                        String messageFromServer = reader.readLine();
                        Controller.addLabel(messageFromServer, vBox);
                    } catch (IOException e) {
                        e.printStackTrace();
                        System.out.println("Lỗi khi nhận tin nhắn từ máy chủ");
                        closeAll();
                        break;
                    }
                }
            }
        }).start();
    }

    public void closeAll() {
        try {
            if (reader != null) {
                reader.close();
            }
            if (writer != null) {
                writer.close();
            }
            if (socket != null) {
                socket.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}