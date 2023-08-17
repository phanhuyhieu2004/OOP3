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

        System.out.print("Nhap phep tinh (so_thu_1 operator so_thu_2): ");

        String input = scanner.nextLine();



        if ("exit".equalsIgnoreCase(input)) {

            clientSocket.close();

        }



        InetAddress serverAddress = InetAddress.getByName(serverIP);

        byte[] sendData = input.getBytes();

        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, serverPort);

        clientSocket.send(sendPacket);



        byte[] receiveData = new byte[65536];

        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);

        clientSocket.receive(receivePacket);



        String result = new String(receivePacket.getData(), 0, receivePacket.getLength());

        System.out.println("Ket qua la: " + result);



        clientSocket.close();

    }

}

