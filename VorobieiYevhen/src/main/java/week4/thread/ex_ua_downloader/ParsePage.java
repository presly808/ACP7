package week4.thread.ex_ua_downloader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Vorobiei on 24.07.2015.
 */
public class ParsePage {
    private String page;

    public ParsePage(String page) {
        this.page = page;
    }
    public HashMap<String, String> linksOnFiles() {
        Pattern pattern = Pattern.compile("/get/[0-9]+' title='[0-9a-zA-ZА-Я-() ._]+");
        Matcher matcher = pattern.matcher(page);
        ArrayList<String> files = new ArrayList<String>();
        while (matcher.find()) {
            files.add(matcher.group());
        }
        HashMap<String,String> linkAndTitle = new HashMap<String, String>();
        for (int i = 0; i < files.size() ; i++) {
            Scanner sc = new Scanner(files.get(i));
            sc.useDelimiter("' title='");
            String link = sc.next();
            String title = sc.next();
            linkAndTitle.put(link, title);
        }
        return linkAndTitle;
    }
}
