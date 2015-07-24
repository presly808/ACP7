package ua.artcode.week3.console_menu.commands;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * Created by Daryna on 13-Jul-15.
 */
public interface Command {
    String run(String currentDir, String commandArgument, PrintWriter out) throws FileNotFoundException;

    String getCommandName();
}
