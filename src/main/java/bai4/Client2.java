package bai4;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client2 {
    public static void main(String[] args) throws IOException {
        String serverIP = "127.0.0.1";
        int serverPort = 1234;
        Socket socket = new Socket(serverIP, serverPort);

        for (int i = 0; i < 2; i++) {
            takeData(socket);
        }

        socket.close();
    }

    private static void takeData(Socket socket) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String number = "";
        System.out.println("nhap so: ");
        number = scanner.next();
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write(number.getBytes());
    }
}


