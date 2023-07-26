package bai4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class NetworkingUseURL {
    public static void main(String[] args) throws IOException, MalformedURLException {

        URL url = new URL("https://www.geeksforgeeks.org/javafx-filechooser-class/");

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()));

        String line;
        while ((line = bufferedReader.readLine()) != null){
            System.out.println(line);
        }

        bufferedReader.close();

    }
}


