import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
    public static void main(String[] args) {
        int port = 8080;

        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Server is running and waiting for connection...");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");

                InputStream inputStream = socket.getInputStream();
                byte[] buffer = new byte[1024];
                int bytesRead = inputStream.read(buffer);
                String message = new String(buffer, 0, bytesRead);
                System.out.println("Received message from client: " + message);

                OutputStream outputStream = socket.getOutputStream();
                String response = "Hello, client. I'm server";
                outputStream.write(response.getBytes());

                socket.close();
                System.out.println("Client disconnected");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}