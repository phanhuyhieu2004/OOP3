package bai4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class NetworkingUseURLConnection {
    public static void main(String[] args) throws IOException, MalformedURLException {
        URL url = new URL("https://www.geeksforgeeks.org/javafx-filechooser-class/");

        URLConnection connection = url.openConnection();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

        String line;

        while ((line = bufferedReader.readLine()) != null){
            System.out.println(line);
        }

        bufferedReader.close();

    }
}


