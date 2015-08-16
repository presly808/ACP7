package ua.artcode.week4.exua;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Daryna on 22-Jul-15.
 */
public class Parser {
    final static Pattern PATTERN = Pattern.compile("<a href='(/get/[0-9]+)' title='(.*)'>");
    final static String SITE_ADDRESS = "http://ex.ua";

    public static HashMap<String, String> getFileLinksAndNames(String content) {
        Matcher matcher = PATTERN.matcher(content);

        HashMap<String, String> linksAndNames = new HashMap<>();

        while (matcher.find()) {
            linksAndNames.put(SITE_ADDRESS + matcher.group(1), matcher.group(2));

        }

        return linksAndNames;
    }
}
