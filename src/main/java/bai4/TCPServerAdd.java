package bai4;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServerAdd {
    public static void main(String[] args) {
        int serverPort = 8080;

        try {
            ServerSocket serverSocket = new ServerSocket(serverPort);
            System.out.println("Server is running and waiting for connections...");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");

                InputStream inputStream = socket.getInputStream();
                byte[] buffer = new byte[1024];
                int bytesRead = inputStream.read(buffer);
                String message = new String(buffer, 0, bytesRead);
                String[] numbers = message.split(" ");

                int num1 = Integer.parseInt(numbers[0]);
                int num2 = Integer.parseInt(numbers[1]);
                int sum = num1 + num2;

                OutputStream outputStream = socket.getOutputStream();
                outputStream.write(String.valueOf(sum).getBytes());

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}