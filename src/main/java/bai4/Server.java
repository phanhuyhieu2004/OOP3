package bai4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        int port = 8080;

        // Tạo một ServerSocket object để lắng nghe các kết nối đến cổng đã chọn
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("Máy chủ đang lắng nghe trên cổng " + port);

        // Chấp nhận kết nối từ một máy khách
        Socket clientSocket = serverSocket.accept();
        System.out.println("Khách  mới được kết nối: " + clientSocket.getInetAddress().getHostAddress());

        // Tạo luồng đọc tin nhắn từ máy khách
        BufferedReader input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        // Tạo luồng ghi tin nhắn tới máy khách
        PrintWriter output = new PrintWriter(clientSocket.getOutputStream(), true);

        // Đọc và gửi tin nhắn liên tục
        String message;
        do {
            // Đọc tin nhắn từ máy khách và hiển thị lên màn hình console
            message = input.readLine();
            System.out.println("Máy khách: " + message);

            // Nhập tin nhắn từ bàn phím và gửi tới máy khách
            System.out.print("Nhập tin nhắn để gửi cho khách hàng (hoặc 'exit' để thoát): ");
            message = new BufferedReader(new InputStreamReader(System.in)).readLine();
            output.println(message);
        } while (!message.equals("exit"));

        // Đóng kết nối khi đã xử lý xong
        clientSocket.close();
        serverSocket.close();
    }
}