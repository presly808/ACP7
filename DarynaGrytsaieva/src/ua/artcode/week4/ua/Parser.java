package ua.artcode.week4.ua;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Daryna on 22-Jul-15.
 */
public class Parser {
    final static Pattern PATTERN = Pattern.compile("<a href='(/get/[0-9]+)' title='(.*)'>");
    final static String SITE_ADDRESS = "http://ex.ua";
    private static String FOLDER;                     // "C:\\Users\\Daryna\\workspace\\parser";

    public Parser(String folder) {
        FOLDER=folder;
    }

    //    public static void main(String[] args) throws IOException {
//        PageReader pageReader = new PageReader("http://www.ex.ua/89940038");
//        String content = pageReader.readWebPage();
//
//        FileDownloader fileDownloader = new FileDownloader();
//
//        for (String link : getLinks(content)) {
//            fileDownloader.download(link, FOLDER);
//        }
//    }

    public static HashMap<String, String> getFileLinksAndNames(String content) {
        Matcher matcher = PATTERN.matcher(content);

        //ArrayList<String> links = new ArrayList<>();
        HashMap<String, String> linksAndNames = new HashMap<>();
        while (matcher.find()) {
            linksAndNames.put(SITE_ADDRESS + matcher.group(1), matcher.group(2));
            //links.add(SITE_ADDRESS + matcher.group(1));
        }

        return linksAndNames;
    }
}
