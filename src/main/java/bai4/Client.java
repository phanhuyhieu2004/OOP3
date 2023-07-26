package bai4;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    public static void main(String[] args) {
        int serverPort = 8080;

        try {
            String severIP = "127.0.0.1";
            int severPort = 8080;
            Socket socket = new Socket(severIP, severPort);

            OutputStream outputStream = socket.getOutputStream();
            String message = "Hello thang l";
            outputStream.write(message.getBytes());
            InputStream input = socket.getInputStream();
            int byteInput;
            while ((byteInput = input.read()) != -1) {
                System.out.print(Character.toString(byteInput));
            }
            socket.close();
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}