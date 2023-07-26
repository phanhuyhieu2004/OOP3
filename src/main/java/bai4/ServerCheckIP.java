package bai4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.regex.Pattern;

public class ServerCheckIP {
    public static void main(String[] args) {
        int serverPort = 8088;
        try {
            ServerSocket serverSocket = new ServerSocket(serverPort);
            System.out.println("Chủ đã sẵn sàng...");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Khách kết nối: " + socket.getInetAddress());

                // Lấy địa chỉ IP từ client
                String IP = readData(socket);

                // Kiểm tra định dạng địa chỉ IP
                boolean isValidIP = isValidIPAddress(IP);

                // Trả về kết quả cho client
                sendData(socket, isValidIP);

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String readData(Socket socket) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String data = reader.readLine();
        return data;
    }

    private static void sendData(Socket socket, boolean isValidIP) throws IOException {
        PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
        if (isValidIP) {
            writer.println("Hợp lệ");
        } else {
            writer.println("K hợp lệ.");
        }
    }

    private static boolean isValidIPAddress(String IP) {
        // Kiểm tra định dạng địa chỉ IP
        String regex0_255 = "([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])";
        String regexIP = regex0_255 + "\\." + regex0_255 + "\\." + regex0_255 + "\\." + regex0_255;
        boolean isValid = Pattern.matches(regexIP, IP);
        return isValid;
    }
}