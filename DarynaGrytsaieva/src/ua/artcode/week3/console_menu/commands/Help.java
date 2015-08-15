package ua.artcode.week3.console_menu.commands;
import ua.artcode.week3.console_menu.CommandUtils;
import ua.artcode.week3.console_menu.InvalidCommandException;
import ua.artcode.week3.console_menu.remote_console.RemoteCommandConsole;

import java.io.PrintWriter;

/**
 * Created by Daryna on 13-Jul-15.
 */
public class Help implements Command {
    private final String COMMAND_NAME = "help";

    public String getCommandName() {
        return COMMAND_NAME;
    }

    @Override
    public String run(String currentDir, String commandArgument, PrintWriter out) {
        if (commandArgument.equals("")) {
            CommandUtils.sendToClient(out, RemoteCommandConsole.getAllCommands());
        } else {
            throw new InvalidCommandException("Invalid command.");
        }
        return currentDir;
    }
}
