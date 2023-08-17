package bai4;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private Socket socket;

    public Client(String serverName, int port) {
        try {
            // Tạo một kết nối tới Server qua địa chỉ IP và cổng của Server
            socket = new Socket(serverName, port);
            System.out.println("Connected to server: " + socket.getInetAddress().getHostAddress());

            // Tạo luồng đọc tin nhắn từ Server
            InputStream input = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));

            // Tạo luồng ghi tin nhắn tới Server
            OutputStream output = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(output, true);

            // Đọc và gửi tin nhắn liên tục
            Scanner scanner = new Scanner(System.in);
            String message;
            do {
                // Nhập tin nhắn từ bàn phím
                System.out.print("Enter message to send to server (or 'exit' to quit): ");
                message = scanner.nextLine();

                // Gửi tin nhắn tới Server
                writer.println(message);

                // Đọc tin nhắn từ Server và hiển thị lên màn hình console
                String response = reader.readLine();
                System.out.println("Received message from server: " + response);
            } while (!message.equals("exit"));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                // Đóng kết nối khi đã gửi xong
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        String serverName = "localhost";
        int port = 8080;
        Client client = new Client(serverName, port);
    }
}
