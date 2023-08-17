package bai4;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private ServerSocket serverSocket;
    private Socket clientSocket;

    public Server(int port) {
        try {
            // Tạo một ServerSocket object để lắng nghe các kết nối đến cổng đã chọn
            serverSocket = new ServerSocket(port);
            System.out.println("Server is listening on port " + port);

            // Chấp nhận kết nối từ Client và xử lý thông điệp
            clientSocket = serverSocket.accept();
            System.out.println("New client connected: " + clientSocket.getInetAddress().getHostAddress());

            // Tạo luồng đọc tin nhắn từ Client
            InputStream input = clientSocket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));

            // Tạo luồng ghi tin nhắn tới Client
            OutputStream output = clientSocket.getOutputStream();
            PrintWriter writer = new PrintWriter(output, true);

            // Đọc và gửi tin nhắn liên tục
            String message;
            do {
                // Đọc tin nhắn từ Client và hiển thị lên màn hình console
                message = reader.readLine();
                System.out.println("Received message from client: " + message);

                // Nhập tin nhắn từ bàn phím
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                System.out.print("Enter message to send to client (or 'exit' to quit): ");
                String response = br.readLine();

                // Gửi tin nhắn tới Client                writer.println(response);
            } while (!message.equals("exit"));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                // Đóng kết nối khi đã xử lý xong
                clientSocket.close();
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        int port = 8080;
        Server server = new Server(port);
    }
}