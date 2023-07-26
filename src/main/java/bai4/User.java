package bai4;


import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class User {
    public static void main(String[] args) throws IOException {
        String IP = "127.0.0.1";
        int serverPort = 8080;
        Socket socket = new Socket(IP,serverPort);

        Scanner input = new Scanner(System.in);
        System.out.println(" nhập ip : ");
        String IPInput = input.next();

        OutputStream outputStream = socket.getOutputStream();
        outputStream.write(IPInput.getBytes());

        String serverRepo = takeData(socket);
        System.out.println(serverRepo);
        socket.close();
    }
    private static String takeData(Socket socket) throws IOException {
        InputStream inputStream = socket.getInputStream();
        byte[] bytes = new byte[2048];
        int readBytes = inputStream.read(bytes);
        String IP = new String(bytes, 0, readBytes);
        return IP;
    }
}
