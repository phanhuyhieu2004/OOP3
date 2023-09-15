import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        String serverIP = "192.168.2.43";
        int serverPort = 9898;
        while(true) {
            DatagramSocket clientSocket = new DatagramSocket();


            Scanner scanner=new Scanner(System.in);
            System.out.print("nhập tin nhắn :");
            String message=scanner.nextLine();
            if("exit".equalsIgnoreCase(message)) {
                clientSocket.close();
                break;
            }
            byte[] dataSend = message.getBytes();
            InetAddress serverAddress = InetAddress.getByName(serverIP);
            DatagramPacket clientPacket = new DatagramPacket(dataSend, dataSend.length, serverAddress, serverPort);
            clientSocket.send(clientPacket);
            byte[] receiveMessage = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(receiveMessage, receiveMessage.length);
            clientSocket.receive(receivePacket);
            String messageFromServer = new String(receivePacket.getData(), 0, receivePacket.getLength());
            System.out.println("Tin nhắn từ MC " + messageFromServer);


        }
    }

}

