package bai5;

import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        DatagramSocket clientSocket = null;
        DatagramPacket sendPacket, receivePacket;
        byte[] sendData, receiveData;
        try {
            // Tạo socket cho máy khách
            clientSocket = new DatagramSocket();
            InetAddress serverIP = InetAddress.getByName("localhost");

            // Gửi yêu cầu kết nối tới máy chủ
            String message = "Chào máy chủ!";
            sendData = message.getBytes();
            sendPacket = new DatagramPacket(sendData, sendData.length, serverIP, 12345);
            clientSocket.send(sendPacket);

            // Nhập tin nhắn từ máy khách và gửi đến máy chủ
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            while (true) {
                // Nhập tin nhắn từ máy khách
                System.out.print("Nhập tin nhắn: ");
                message = input.readLine();

                // Kiểm tra tin nhắn đó có phải là "bye" không
                if (message.equals("bye")) {
                    sendData = message.getBytes();
                    sendPacket = new DatagramPacket(sendData, sendData.length, serverIP, 12345);
                    clientSocket.send(sendPacket);
                    break;
                }

                // Gửi tin nhắn đến máy chủ
                sendData = message.getBytes();
                sendPacket = new DatagramPacket(sendData, sendData.length, serverIP, 12345);
                clientSocket.send(sendPacket);

                // Nhận tin nhắn từ máy chủ và in ra màn hình
                receiveData = new byte[1024];
                receivePacket = new DatagramPacket(receiveData, receiveData.length);
                clientSocket.receive(receivePacket);
                message = new String(receivePacket.getData(), 0, receivePacket.getLength());
                System.out.println("Đã nhận tin nhắn từ máy chủ: " + message);

                // Kiểm tra tin nhắn đó có phải là "bye" không
                if (message.equals("bye")) {
                    break;
                }
            }
            clientSocket.close();
        } catch (IOException e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
    }
}