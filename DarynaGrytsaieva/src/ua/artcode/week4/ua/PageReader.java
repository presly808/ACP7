package ua.artcode.week4.ua;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by Daryna on 22-Jul-15.
 */
public class PageReader {

    private HttpURLConnection connection;

    public PageReader(String url) throws IOException {
        connection = getHttpURLConnection(new URL(url));
    }

    private HttpURLConnection getHttpURLConnection(URL url) throws IOException {
        URLConnection urlConnection = url.openConnection();
        if (urlConnection instanceof HttpURLConnection) {
            return connection = (HttpURLConnection) urlConnection;
        } else {
            System.out.println("Please enter an HTTP URL.");
            return null;
        }
    }

    public String readPageContent() throws IOException {
        BufferedReader in = new BufferedReader(
                new InputStreamReader(connection.getInputStream()));
        String pageContent = "";
        String currentLine;
        while ((currentLine = in.readLine()) != null) {
            pageContent += currentLine+"\n";
        }
        return pageContent;
    }


}
