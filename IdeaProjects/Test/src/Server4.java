import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server4 {
    private static final int SERVER_PORT = 8082;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(SERVER_PORT);
        System.out.println("Server is running. Waiting for client connection...");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected.");

            // Đọc bán kính từ client
            InputStream inputStream = socket.getInputStream();
            byte[] buffer = new byte[1024];
            int bytesRead = inputStream.read(buffer);
            String radiusString = new String(buffer, 0, bytesRead);
            double radius = Double.parseDouble(radiusString);

            // Tính diện tích hình tròn
            double area = calculateCircleArea(radius);

            // Gửi kết quả về client
            OutputStream outputStream = socket.getOutputStream();
            String areaString = Double.toString(area);
            outputStream.write(areaString.getBytes());

            socket.close();
            System.out.println("Client disconnected.");
        }
    }

    public static double calculateCircleArea(double radius) {
        return Math.PI * radius * radius;
    }
}
