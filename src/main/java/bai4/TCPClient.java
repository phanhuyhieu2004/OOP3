package bai4;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class TCPClient {
    public static void main(String[] args) {

        // Đặt địa chỉ IP và cổng kết nối của server
        String serverAddress = "127.0.0.1";
        int serverPort = 8082;

        try {
            // Tạo socket để kết nối đến server
            Socket socket = new Socket(serverAddress, serverPort);
            System.out.println("Đã kết nối với máy chủ");

            // Ghi dữ liệu tới server
            OutputStream outputStream = socket.getOutputStream();
            String message = "Hello, server. I'm client";
            outputStream.write(message.getBytes());

            // Đọc dữ liệu từ server
            InputStream inputStream = socket.getInputStream();
            byte[] buffer = new byte[1024];
            int bytesRead = inputStream.read(buffer);
            String response = new String(buffer, 0, bytesRead);
            System.out.println("Nhận được tin nhắn từ máy chủ: " + response);

            // Không đóng kết nối ở đây
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}