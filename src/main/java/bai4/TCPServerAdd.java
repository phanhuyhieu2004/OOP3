package bai4;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServerAdd {
    public static void main(String[] args) {
        // Cổng kết nối của server
        int serverPort = 8080;

        try {
            // Tạo một ServerSocket để lắng nghe kết nối từ client
            ServerSocket serverSocket = new ServerSocket(serverPort);
            System.out.println("Máy chủ đang chạy và chờ kết nối...");

            while (true) {
                // Chấp nhận kết nối từ client
                Socket socket = serverSocket.accept();
                System.out.println("Máy khách đã kết nối");

                // Nhận hai số nguyên từ client
                InputStream inputStream = socket.getInputStream();
                byte[] buffer = new byte[1024];
                int bytesRead = inputStream.read(buffer);
                String message = new String(buffer, 0, bytesRead);
                String[] numbers = message.split(" ");
                int num1 = Integer.parseInt(numbers[0]);
                int num2 = Integer.parseInt(numbers[1]);

                // Tính tổng của hai số và gửi lại kết quả cho client
                int sum = num1 + num2;
                OutputStream outputStream = socket.getOutputStream();
                outputStream.write(String.valueOf(sum).getBytes());

                // Đóng kết nối với client
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}