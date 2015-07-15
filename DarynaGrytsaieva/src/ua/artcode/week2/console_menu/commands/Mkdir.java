package ua.artcode.week2.console_menu.commands;

import art_code.console_menu.CommandUtils;
import art_code.console_menu.InvalidCommandException;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * Created by Daryna on 14-Jul-15.
 */
public class Mkdir implements Command {
    private final String COMMAND_NAME = "mkdir";

    @Override
    public String getCommandName() {
        return COMMAND_NAME;
    }

    @Override
    public String run(String currentDir, String commandArgument) throws FileNotFoundException {
        String newDir = getNewDir(currentDir, commandArgument);
        if (CommandUtils.dirExists(newDir)) {
            System.out.println("Directory already exists.");
            return currentDir;
        } else {
            File dir = new File(newDir);
            dir.mkdir();
            return newDir;
        }

    }

    private String getNewDir(String currentDir, String commandArgument) {

        if (commandArgument.contains(" ") || commandArgument.equals("")) {
            throw new InvalidCommandException("Invalid argument.");

        } else {
            return (currentDir + "/" + commandArgument);
        }
    }


}
