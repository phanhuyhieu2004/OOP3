package bai5;

import java.io.IOException;
import java.net.*;

public class Client {
    public static void main(String[] args) throws IOException {
        String serverIp = "localhost";
        int serverPort = 12345;

        DatagramSocket clientSocket = new DatagramSocket();

        String message = "";
        byte[] sendData;
        DatagramPacket sendPacket;
        byte[] receiveData = new byte[1024];
        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);

        while (true) {
            // Nhập tin nhắn từ bàn phím
            System.out.print("Enter message (type 'exit' to quit): ");
            message = System.console().readLine();

            // Nếu tin nhắn là "exit" thì thoát khỏi vòng lặp
            if (message.equals("exit")) {
                break;
            }

            // Gửi tin nhắn đến server
            sendData = message.getBytes();
            InetAddress serverAddress = InetAddress.getByName(serverIp);
            sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, serverPort);
            clientSocket.send(sendPacket);

            // Nhận phản hồi từ server
            receivePacket = new DatagramPacket(receiveData, receiveData.length);
            clientSocket.receive(receivePacket);
            String responseMessage = new String(receivePacket.getData(), 0, receivePacket.getLength());
            System.out.println("Received from server: " + responseMessage);
        }

        // Đóng kết nối
        clientSocket.close();
    }
}