import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private static final int SERVER_PORT = 8081;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(SERVER_PORT);
        Socket socket = serverSocket.accept();
        System.out.println("Server đang chạy và chờ Client kết nối đến");
        InputStream inputStream = socket.getInputStream();
        OutputStream outputStream = socket.getOutputStream();
        byte[] buffer = new byte[1024];
        while (true) {
            int byteRead = inputStream.read(buffer);
            if (byteRead != -1) {
                String numberString = new String(buffer, 0, byteRead);
                boolean isNumber = true;
                try {
                    int number = Integer.parseInt(numberString);
                    boolean checkCl = checkChanLe(number);
                    String messagetoSend = checkCl ? " Số " + number + "  là số chẵn " : "  Số  " + number + "  là số lẻ  ";
                    outputStream.write(messagetoSend.getBytes());
                } catch (NumberFormatException e) {
                    isNumber = false;
                    String errorMessagetoSend = " Dữ liệu nhập vào không phải là số";
                    outputStream.write(errorMessagetoSend.getBytes());
                }
                if (!isNumber) {
                    break;
                }
            }
        }
    }

    public static boolean checkChanLe(int number) {
        return number % 2 == 0;
    }
}