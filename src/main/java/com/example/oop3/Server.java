package com.example.oop3.bai1;

import com.example.oop3.Controller;
import javafx.scene.layout.VBox;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private ServerSocket serverSocket;
    private Socket socket;
    private BufferedReader bufferReader;
    private BufferedWriter bufferedWriter;

    public Server(ServerSocket serverSocket) throws IOException {
        try {
            this.serverSocket = serverSocket;
            this.socket = serverSocket.accept();
            this.bufferReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        } catch (IOException e) {
            System.out.println("Lỗi khi tạo máy chủ");
            e.printStackTrace();
        }

    }
    public void sendMessageToClient(String messageToClient){
        try{
            bufferedWriter.write(messageToClient);
            bufferedWriter.newLine();
            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Lỗi khi gửi tin nhắn cho máy chủ !!!");
            closeEverything(socket,bufferReader,bufferedWriter);
        }
    }
    public void recieveMessageFromClient(VBox vBox){
new Thread(new Runnable() {
    @Override
    public void run() {
        while(socket.isConnected()){
            try {
                String messageFromClient=bufferReader.readLine();
                Controller.addLabel(messageFromClient,vBox);
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Lỗi khi nhận tin nhắn từ máy khách");
                closeEverything(socket,bufferReader,bufferedWriter);
                break;
            }
        }
    }
}).start();
    }

    public void closeEverything(Socket socket, BufferedReader buffrerReader, BufferedWriter bufferWriter) {
        try {
            if (bufferReader != null) {
                bufferReader.close();
            }
            if (bufferWriter != null) {
                bufferWriter.close();
            }
            if (socket != null) {
                socket.close();
            }


        } catch (IOException e) {
            e.printStackTrace();

        }
    }
}
