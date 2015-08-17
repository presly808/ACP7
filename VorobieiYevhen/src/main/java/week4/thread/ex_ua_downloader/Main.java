package week4.thread.ex_ua_downloader;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Джек on 23.07.2015.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        URL page = getUrl();
        String text = new PageDownload(page).loadPage();
        //System.out.println(text);
        HashMap<String, String> linkTitle = new ParsePage(text).linksOnFiles();
        new FIleLoader(linkTitle).downloadFiles();
    }


    private static URL getUrl() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter page address: ");
        return new URL(bufferedReader.readLine());
    }


}
