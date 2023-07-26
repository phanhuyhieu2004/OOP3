package bai4;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.regex.Pattern;

public class ServerCheckIP {
    public static void main(String[] args) {

        int serverPort = 8080;
        try {
            ServerSocket serverSocket = new ServerSocket(serverPort);
            Socket socket = serverSocket.accept();

            String IP = takeData(socket);

            // [0-9] : lấy trường hợp số từ 0-9
            // [1-9][0-9] : lấy số hàng chục 10-99
            // 1[0-9][0-9] : lấy số từ 100 - 199
            // 2[0-4][0-9] : lấy số từ 200-249
            // 25[0-5] : lấy số từ 250-255
            // regex0_255 là regex lấy số từ 0-255
            String regex0_255 = "([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])";
            if (Pattern.matches(regex0_255 + "\\." + regex0_255, IP)) {
                repoData(socket,true);
            } else {
                repoData(socket,false);
            }

            serverSocket.close();
            socket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String takeData(Socket socket) throws IOException {
        InputStream inputStream = socket.getInputStream();
        byte[] bytes = new byte[2048];
        int readBytes = inputStream.read(bytes);
        String IP = new String(bytes, 0, readBytes);
        return IP;
    }

    private static void repoData(Socket socket,boolean isIP) throws IOException {
        // trả về dữ liệu cho client
        OutputStream outputStream = socket.getOutputStream();
        if (isIP) {
            outputStream.write("regex is true!".getBytes());
        } else {
            outputStream.write("regex is false!".getBytes());
        }

    }
}
