package ua.artcode.week2.console_menu.commands;

import art_code.console_menu.InvalidCommandException;

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
    public String run(String currentDir, String commandArgument) {
        if(commandArgument.equals("")){
            System.exit(0);

        }else{
            throw new InvalidCommandException("Invalid command.");
        }
        return currentDir;
    }


}
