package bai5;
import java.io.*;
import java.net.*;
import java.util.Scanner;

package bai5;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ClientCalculator {
    public static void main(String[] args) throws IOException {
        String serverIP = "localhost";
        int serverPort = 6969;

        DatagramSocket clientSocket = new DatagramSocket();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the operation (number_1 operator number_2): ");

        String input = scanner.nextLine();

        if ("exit".equalsIgnoreCase(input)) {
            clientSocket.close();
            System.exit(0);
        }

        InetAddress serverAddress = InetAddress.getByName(serverIP);
        byte[] sendData = input.getBytes();
        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, serverPort);
        clientSocket.send(sendPacket);

        byte[] receiveData = new byte[1024];
        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
        clientSocket.receive(receivePacket);

        String result = new String(receivePacket.getData(), 0, receivePacket.getLength());
        System.out.println("The result is: " + result);

        clientSocket.close();
    }
}