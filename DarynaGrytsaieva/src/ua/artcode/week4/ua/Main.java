package ua.artcode.week4.ua;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Daryna on 22-Jul-15.
 */
public class Main {
    final static String FOLDER = "C:\\Users\\Daryna\\workspace\\parser";
    final static String EX_UA_PAGE = "http://www.ex.ua/89940038";

    public static void main(String[] args) throws IOException {

        PageReader pageReader = new PageReader(EX_UA_PAGE);
        String pageContent = pageReader.readPageContent();

        HashMap<String, String> linksAndNames = new Parser(FOLDER).getFileLinksAndNames(pageContent);

        FileDownloader fileDownloader = new FileDownloader();

        for (Map.Entry<String, String> link : linksAndNames.entrySet()) {
            fileDownloader.download(link.getKey(), FOLDER, link.getValue());
        }
    }
}
