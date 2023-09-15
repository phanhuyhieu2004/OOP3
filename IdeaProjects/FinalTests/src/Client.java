import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private static final int SERVER_PORT = 8081;
    private static final String  SERVER_IP = "localhost";

    public static void main(String[] args) throws IOException {
        Socket socket=new Socket(SERVER_IP,SERVER_PORT);
        System.out.println("Client đã kết nối thành công ");
        InputStream inputStream=socket.getInputStream();
        byte[] buffer=new byte[1024];
        while(true){
            Scanner scanner =new Scanner(System.in);
            System.out.print("Nhập tin nhắn(Nếu không muốn thì nhập exit để thoát) :");
            String inputmessage=scanner.nextLine();
            if("exit".equalsIgnoreCase(inputmessage)){
                socket.close();
                break;
            }

            OutputStream outputStream=socket.getOutputStream();
            outputStream.write(inputmessage.getBytes());

            int byteRead=inputStream.read(buffer);
            if(byteRead != -1){
                String messageFromServer=new String(buffer,0,byteRead);
                System.out.println("Tin nhắn từ Server là : " + messageFromServer);

            }

        }

    }

}
