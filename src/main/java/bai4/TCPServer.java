package bai4;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
    public static void main(String[] args) {

        // Đặt cổng kết nối mà server sẽ lắng nghe
        int port = 8082;

        try {
            // Tạo socket server
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Máy chủ đang chạy và chờ kết nối...");

            // Vòng lặp vô hạn để chấp nhận các kết nối từ client
            while (true) {

                // Chấp nhận kết nối từ client
                Socket socket = serverSocket.accept();
                System.out.println("Máy khách đã kết nối");

                // Đọc dữ liệu từ client
                InputStream inputStream = socket.getInputStream();
                byte[] buffer = new byte[1024];
                int bytesRead = inputStream.read(buffer);
                String message = new String(buffer, 0, bytesRead);
                System.out.println("Nhận được tin nhắn từ khách : " + message);

                // Ghi dữ liệu trả lời về client
                OutputStream outputStream = socket.getOutputStream();
                String response = "Hello, client. I'm server";
                outputStream.write(response.getBytes());

                // Đóng kết nối
                socket.close();
                System.out.println("Máy khách kết nối");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}