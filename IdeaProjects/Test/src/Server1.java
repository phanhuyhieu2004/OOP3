import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server1 {
    private static final int SERVER_PORT = 8081;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(SERVER_PORT);
        System.out.println("Server đang chạy và sẵn sàng kết nối...");
        Socket socket = serverSocket.accept();
        System.out.println("Client đã kết nối thành công.");

        // Gửi dữ liệu từ Server tới Client
        OutputStream outputStream = socket.getOutputStream();
        InputStream inputStream = socket.getInputStream();
        byte[] buffer = new byte[1024];

        while (true) {
            // Đọc số từ Client
            int bytesRead = inputStream.read(buffer);
            if (bytesRead != -1) {
                String numberString = new String(buffer, 0, bytesRead);
                int number = Integer.parseInt(numberString);

                // Kiểm tra số nguyên tố
//                boolean isPrime = isPrimeNumber(number);
                // Kiểm tra số chẵn lẻ
                String evenOddMessage = isEven(number) ? "Số " + number + " là số chẵn." : "Số " + number + " là số lẻ.";

                // Gửi kết quả cho Client
//                String messageToSend = isPrime ? "Số " + number + " là số nguyên tố." : "Số " + number + " không là số nguyên tố.";
                outputStream.write(evenOddMessage.getBytes());
            }
        }
    }

//    private static boolean isPrimeNumber(int number) {
//        if (number <= 1) {
//            return false;
//        }
//
//        for (int i = 2; i <= Math.sqrt(number); i++) {
//            if (number % i == 0) {
//                return false;
//            }
//        }
//
//        return true;
//    }
    public static boolean isEven(int number) {
        return number % 2 == 0;
    }
    public static double calculateCircleArea(double radius) {
        return Math.PI * radius * radius;
    }
}