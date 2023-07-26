package bai4;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class NetworkingUseInetAddress {
    public static void main(String[] args) {
        try {
            // Lấy địa chỉ IP của trang web
            InetAddress address = InetAddress.getByName("www.example.com");

            // In địa chỉ IP và tên miền của trang web
            String ipAddress = address.getHostAddress();
            System.out.println("Địa chỉ IP: " + ipAddress);

            String hostName = address.getHostName();
            System.out.println("Tên miền: " + hostName);

            // Kiểm tra xem trang web có thể truy cập được hay không
            boolean reachable = address.isReachable(5000);
            System.out.println("Truy cập được: " + reachable);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}