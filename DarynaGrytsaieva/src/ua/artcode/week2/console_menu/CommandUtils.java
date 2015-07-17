package ua.artcode.week2.console_menu;

import java.io.File;

/**
 * Created by Daryna on 13-Jul-15.
 */
public class CommandUtils {
    public static boolean dirExists(String path){
        File f = new File(path);
        return f.isDirectory();
    }

    public static boolean fileExists(String path){
        File f = new File(path);
        return f.isFile();
    }

    public static String getNewDir(String currentDir, String commandArgument) {

        if (commandArgument.contains(" ")) {
            throw new InvalidCommandException("Invalid argument.");
        }
        if (commandArgument.equals("")) {
            return currentDir;
        } else {
            return (currentDir + "/" + commandArgument);
        }
    }
}
