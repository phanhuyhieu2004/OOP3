import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) throws IOException {

        int serverPort=8088;
        DatagramSocket serverSocket=new DatagramSocket(serverPort);
        System.out.println("Sever đang chạy.....");
        while(true){
            byte[] receiveMessage = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(receiveMessage, receiveMessage.length);
            serverSocket.receive(receivePacket);
            String messageFromClient = new String(receivePacket.getData(), 0, receivePacket.getLength());
            System.out.println("Tin nhắn từ MK là  " + messageFromClient);
            Scanner scanner=new Scanner(System.in);
            System.out.print("Nhập tin nhắn:");
            String message=scanner.nextLine();
            if("exit".equalsIgnoreCase(message)) {
                serverSocket.close();
                break;
            }

                byte[] dataSend = message.getBytes();
                InetAddress clientAddress = receivePacket.getAddress();
                int clientPort = receivePacket.getPort();
                DatagramPacket sendPacket = new DatagramPacket(dataSend, dataSend.length, clientAddress, clientPort);
                serverSocket.send(sendPacket);


        }
    }
}
