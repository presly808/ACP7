package ua.artcode.week2.allCommands;

import java.io.File;

/**
 * Created by Олександр on 15.07.2015.
 */
public class ConsoleHelper {

    private ConsoleHelper(){};

    static boolean find(String path){
        File file = new File(path);
        return file.exists();

    }
}
