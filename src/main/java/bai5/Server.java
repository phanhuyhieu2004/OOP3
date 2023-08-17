package bai5;
import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        DatagramSocket serverSocket = null;
        DatagramPacket receivePacket, sendPacket;
        byte[] receiveData, sendData;
        try {
            // Tạo socket cho máy chủ
            serverSocket = new DatagramSocket(12345);
            System.out.println("Máy chủ đã khởi động...");

            // Chờ kết nối từ máy khách
            receiveData = new byte[1024];
            receivePacket = new DatagramPacket(receiveData, receiveData.length);
            serverSocket.receive(receivePacket);
            InetAddress clientIP = receivePacket.getAddress();
            int clientPort = receivePacket.getPort();
            System.out.println("Máy khách đã kết nối với máy chủ.");

            // Nhận tin nhắn từ máy khách và in ra màn hình
            while (true) {
                receiveData = new byte[1024];
                receivePacket = new DatagramPacket(receiveData, receiveData.length);
                serverSocket.receive(receivePacket);
                String message = new String(receivePacket.getData(), 0, receivePacket.getLength());
                System.out.println("Đã nhận tin nhắn từ máy khách: " + message);

                // Kiểm tra tin nhắn đó có phải là "bye" không
                if (message.equals("bye")) {
                    break;
                }

                // Nhập tin nhắn từ máy chủ
                BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
                System.out.print("Nhập tin nhắn: ");
                message = input.readLine();

                // Kiểm tra tin nhắn đó có phải là "bye" không
                if (message.equals("bye")) {
                    sendData = message.getBytes();
                    sendPacket = new DatagramPacket(sendData, sendData.length, clientIP, clientPort);
                    serverSocket.send(sendPacket);
                    break;
                }

                // Gửi tin nhắn đến máy khách
                sendData = message.getBytes();
                sendPacket = new DatagramPacket(sendData, sendData.length, clientIP, clientPort);
                serverSocket.send(sendPacket);
            }
            serverSocket.close();
        } catch (IOException e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
    }
}