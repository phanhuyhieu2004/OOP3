package bai4;

import java.net.ServerSocket;
import java.net.Socket;

public class BaiTap13_Server {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // Tạo server socket và lắng nghe
            int port = 99;
            ServerSocket serverSocket = new ServerSocket(port);

            // Chấp nhận nhiều kết nối
            while(true){
                // Chấp nhận kết nối từ 1 Client
                Socket clientSocket = serverSocket.accept();
                MyProcess mp = new MyProcess(clientSocket);
                mp.start();
            }

        }catch(Exception e){
            e.printStackTrace();
        }
    }

}