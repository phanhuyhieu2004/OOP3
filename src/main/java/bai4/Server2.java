package bai4;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server2 {
    public static void main(String[] args) {
        int serverPort = 1234;
        try {
            ServerSocket serverSocket = new ServerSocket(serverPort);
            Socket socket = serverSocket.accept();
            int result = 0;

            for (int i = 0; i < 2; i++) {
                result = takeData(socket, result);
            }

            System.out.println(result);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int takeData(Socket socket, int result) throws IOException {
        InputStream inputStream = socket.getInputStream();
        byte[] bytes = new byte[2048];
        int readBytes = inputStream.read(bytes);
        String number = new String(bytes,0,readBytes);

        result += Integer.parseInt(number);
        return result;
    }
}

