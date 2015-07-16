package ua.artcode.week2.allCommands;

import java.io.IOException;

/**
 * Created by Олександр on 11.07.2015.
 */
public interface Commands {

    String  getHelp();

    Object run(String currentPath, String param) throws IOException;
}
