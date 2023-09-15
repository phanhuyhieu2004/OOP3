import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client1 {
    private static final String SERVER_IP = "127.0.0.1";
    private static final int SERVER_PORT = 8082;

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(SERVER_IP, SERVER_PORT);
        System.out.println("Connected to server.");

        // Đọc dữ liệu từ Server
        InputStream inputStream = socket.getInputStream();
        byte[] buffer = new byte[1024];

        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Nhap tin nhan (or 'exit' to quit): ");
            String inputLine = scanner.nextLine();

            if ("exit".equalsIgnoreCase(inputLine)) {
                socket.close();
                break;
            }

            // Gửi số cho Server
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write(inputLine.getBytes());

            // Đọc kết quả từ Server
            int bytesRead = inputStream.read(buffer);
            if (bytesRead != -1) {
                String messageReceived = new String(buffer, 0, bytesRead);
                System.out.println("Tin nhan nhan tu sv la: " + messageReceived);
            }
        }
    }
}