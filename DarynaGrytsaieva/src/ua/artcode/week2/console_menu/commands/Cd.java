package ua.artcode.week2.console_menu.commands;

import art_code.console_menu.CommandUtils;
import art_code.console_menu.InvalidCommandException;

/**
 * Created by Daryna on 13-Jul-15.
 */
public class Cd implements Command {
    private final String COMMAND_NAME = "cd";

    public String getCommandName() {
        return COMMAND_NAME;
    }

    @Override
    public String run(String currentDir, String commandArgument) {
        String newDir = getNewDir(currentDir, commandArgument);


        if (CommandUtils.dirExists(newDir)) {
            return newDir;
        }

        int index = newDir.lastIndexOf("\\");
        return newDir.substring(0, index);


    }

    private String getNewDir(String currentDir, String commandArgument) {

        if (commandArgument.contains(" ")) {
            throw new InvalidCommandException("Invalid argument.");
        }
        if (commandArgument.equals("..")) {
            int index = currentDir.lastIndexOf("\\");
            return (currentDir.substring(0, index));
        }
        if (commandArgument.equals("")) {
            return currentDir;
        } else {
            return (currentDir + "\\" + commandArgument);
        }
    }


}
