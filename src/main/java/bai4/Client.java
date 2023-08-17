package bai4;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        String serverName = "localhost";
        int port = 8080;

        // Tạo một kết nối tới máy chủ qua địa chỉ IP và cổng của máy chủ
        Socket socket = new Socket(serverName, port);
        System.out.println("Kết nối đến máy chủ: " + socket.getInetAddress().getHostAddress());

        // Tạo luồng đọc tin nhắn từ máy chủ
        BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//        InputStreamReader chuyển đổi các byte đọc được từ InputStream thành các ký tự có thể đọc được.
//        đọc dữ liệu từ socket theo dạng các ký tự có thể đọc được

        // Tạo luồng ghi tin nhắn tới máy chủ
        PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
//        tạo một đối tượng PrintWriter để ghi dữ liệu vào OutputStream của socket và đặt chế độ tự động xả dữ liệu để đảm bảo dữ liệu được gửi đi ngay sau mỗi lần ghi.

        // Đọc và gửi tin nhắn liên tục
        String message;
        do {
            // Nhập tin nhắn từ bàn phím và gửi tới máy chủ
            System.out.print("Nhập tin nhắn để gửi cho máy chủ (hoặc 'exit' để thoát): ");
            message = new BufferedReader(new InputStreamReader(System.in)).readLine();
//            sử dụng BufferedReader và InputStreamReader để đọc dữ liệu từ bàn phím. Sau đó, readLine() được gọi để đọc dòng nhập từ bàn phím và gán giá trị cho biến message.
            output.println(message);

            // Đọc tin nhắn từ máy chủ và hiển thị lên màn hình console
            message = input.readLine();
            System.out.println("Máy chủ :" + message);
        } while (!message.equals("exit"));

        // Đóng kết nối khi đã gửi xong        socket.close();
    }
}