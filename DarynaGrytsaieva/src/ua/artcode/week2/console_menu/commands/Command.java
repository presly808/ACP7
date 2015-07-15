package ua.artcode.week2.console_menu.commands;

import java.io.FileNotFoundException;

/**
 * Created by Daryna on 13-Jul-15.
 */
public interface Command {
     String run(String currentDir, String commandArgument) throws FileNotFoundException;

     String getCommandName();
}
