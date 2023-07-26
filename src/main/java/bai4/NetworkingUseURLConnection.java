package bai4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class NetworkingUseURLConnection {
    public static void main(String[] args) throws IOException, MalformedURLException {
        // Tạo đối tượng URL
        URL url = new URL("https://www.geeksforgeeks.org/javafx-filechooser-class/");

        // Mở kết nối tới URL
        URLConnection connection = url.openConnection();

        // Tạo bufferedReader để đọc nội dung từ kết nối
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

        // Đọc từng dòng nội dung và in ra màn hình
        String line;
        while ((line = bufferedReader.readLine()) != null){
            System.out.println(line);
        }

        // Đóng bufferedReader khi kết thúc
        bufferedReader.close();
    }
}