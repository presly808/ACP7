package ua.artcode.week3.console_menu.commands;

import ua.artcode.week3.console_menu.CommandUtils;
import ua.artcode.week3.console_menu.InvalidCommandException;

import java.io.PrintWriter;

/**
 * Created by Daryna on 14-Jul-15.
 */
public class Exit implements Command {
    private final String COMMAND_NAME = "exit";

    @Override
    public String getCommandName() {
        return COMMAND_NAME;
    }
    @Override
    public String run(String currentDir, String commandArgument, PrintWriter out) {
        if(commandArgument.equals("")){
            System.exit(0);

        }else{
            throw new InvalidCommandException("Invalid command.");
        }
        return currentDir;
    }


}
