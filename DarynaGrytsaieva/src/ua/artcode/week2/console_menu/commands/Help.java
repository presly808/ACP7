package ua.artcode.week2.console_menu.commands;

import art_code.console_menu.InvalidCommandException;
import art_code.console_menu.simple_console.CommandConsole;

/**
 * Created by Daryna on 13-Jul-15.
 */
public class Help implements Command {
    private final String COMMAND_NAME = "help";

    public String getCommandName() {
        return COMMAND_NAME;
    }

    @Override
    public String run(String currentDir, String commandArgument) {
        if (commandArgument.equals("")) {
            CommandConsole.printAllCommands();
        }else{
            throw new InvalidCommandException("Invalid command.");
        }
        return currentDir;
    }
}
