package bai4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientCheckIP {
    public static void main(String[] args) {
        String serverHost = "localhost";
        int serverPort = 8088;
        try {
            Socket socket = new Socket(serverHost, serverPort);
            System.out.println("Đã kết nối với máy chủ...");

            Scanner scanner = new Scanner(System.in);
            System.out.print("Nhập IP: ");
            String IP = scanner.nextLine();

            // Gửi địa chỉ IP tới server
            sendData(socket, IP);

            // Đọc kết quả từ server
            String result = readData(socket);
            System.out.println("Kết quả: " + result);

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void sendData(Socket socket, String data) throws IOException {
        PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
        writer.println(data);
    }

    private static String readData(Socket socket) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String data = reader.readLine();
        return data;
    }
}