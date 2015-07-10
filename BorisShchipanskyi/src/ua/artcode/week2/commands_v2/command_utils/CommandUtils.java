package ua.artcode.week2.commands_v2.command_utils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by boris on 7/9/15.
 */
public class CommandUtils {
    private static final String SPACE = " ";
    public static String getCommand(String line){
        if(line.indexOf(SPACE) < 0){
            return line;
        }
        int indexSpace = line.indexOf(SPACE);

        return line.substring(0, indexSpace);
    }

    public static List<String> getFilters(String line){
        List<String> filters = new ArrayList<>();
        String pattern = "(\\s\\-\\w)";
        Pattern reg = Pattern.compile(pattern);
        Matcher m = reg.matcher(line);
        while(m.find()) {
            filters.add(m.group(m.groupCount()).trim());
        }
        return filters;
    }

    public static List<String> getParams(String line){
        String command = getCommand(line);
        List<String> filters =  getFilters(line);
        List<String> params = new ArrayList<>();
        String[] words = line.split(SPACE);
        for(int i = 0; i < words.length; i++){
            if(!command.equals(words[i]) &&  !checkStrInList(words[i], filters)){
                params.add(words[i]);
            }
        }
        return params;

    }
    private static boolean checkStrInList(String str, List<String> strings){
        for(String s: strings){
            if(s.contains(str)){
                return true;
            }
        }
        return false;

    }
}
