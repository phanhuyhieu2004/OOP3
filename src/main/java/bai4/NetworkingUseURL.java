package bai4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class NetworkingUseURL {
    public static void main(String[] args) throws IOException, MalformedURLException {

        // Tạo đối tượng URL từ đường dẫn web
        URL url = new URL("https://www.geeksforgeeks.org/javafx-filechooser-class/");

        // Tạo đối tượng BufferedReader để đọc nội dung từ URL
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()));

        String line;
        // Đọc từng dòng trong nội dung web và in ra console
        while ((line = bufferedReader.readLine()) != null){
            System.out.println(line);
        }

        // Đóng BufferedReader
        bufferedReader.close();

    }
}