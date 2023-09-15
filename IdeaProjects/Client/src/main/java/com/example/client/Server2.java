package com.example.client;


import javafx.scene.control.Label;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server2 {
    private Socket socket;
    private ServerSocket serverSocket;
    private BufferedReader bufferedReader;
    private BufferedWriter bufferedWriter;
    public  Server2 (ServerSocket serverSocket){
        try {
            this.serverSocket = serverSocket;
            this.socket = serverSocket.accept();
            this.bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        } catch (IOException e) {
            e.printStackTrace();

        }
    }
    public void SendMessageToClient(String message) {
        try {
            bufferedWriter.write(message);
            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readFromClient(Label label) throws IOException {
        new Thread(() -> {
            while (socket.isConnected())
                try {
                    String messageByte = bufferedReader.readLine();
                    label.setText(messageByte);
                }catch (IOException e){
                    e.printStackTrace();
                    break;
                }
        });
    }

}