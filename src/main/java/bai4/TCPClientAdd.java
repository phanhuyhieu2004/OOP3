package bai4;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class TCPClientAdd {
    public static void main(String[] args) {
        // Địa chỉ IP của server
        String serverAddress = "127.0.0.1";
        // Cổng kết nối của server
        int serverPort = 8089;

        try {
            // Nhập vào hai số nguyên từ bàn phím
            Scanner scanner = new Scanner(System.in);
            System.out.print("Nhập số đầu tiên: ");
            int num1 = scanner.nextInt();
            System.out.print("Nhập số thứ hai: ");
            int num2 = scanner.nextInt();

            // Kết nối tới server
            Socket socket = new Socket(serverAddress, serverPort);
            // Gửi hai số nguyên lên server
            OutputStream outputStream = socket.getOutputStream();
            String message = num1 + " " + num2;
            outputStream.write(message.getBytes());

            // Nhận kết quả từ server và in ra màn hình
            InputStream inputStream = socket.getInputStream();
            byte[] buffer = new byte[1024];
            int bytesRead = inputStream.read(buffer);
            String response = new String(buffer, 0, bytesRead);
            System.out.println("Tổng của hai số là:" + response);

            // Đóng kết nối với server
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
