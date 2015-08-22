package week4.thread.ex_ua_downloader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * Created by Vorobiei on 24.07.2015.
 */
public class PageDownload {
    private URL page;

    public PageDownload(URL page) {
        this.page = page;
    }
    public String loadPage () throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(page.openStream()));
        StringBuilder stringBuilder = new StringBuilder();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            stringBuilder.append(line + "\n");
        }
        bufferedReader.close();
        return stringBuilder.toString();
    }
}
