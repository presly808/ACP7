package ua.artcode.week2.console_menu.commands;

import art_code.console_menu.CommandUtils;
import art_code.console_menu.InvalidCommandException;

import java.io.File;

/**
 * Created by Daryna on 13-Jul-15.
 */
public class Dir implements Command {
    private final String COMMAND_NAME = "dir";

    public String getCommandName() {
        return COMMAND_NAME;
    }

    @Override
    public String run(String currentDir, String commandArgument) {
        String newDir = getNewDir(currentDir, commandArgument);

        if (CommandUtils.dirExists((newDir))) {
            File f = new File(newDir);
            File[] files = f.listFiles();
            for (File temp : files) {
                System.out.println(temp.getName().toString());
            }
            return newDir;
        }

        return currentDir;
    }
    private String getNewDir(String currentDir, String commandArgument) {

        if (commandArgument.contains(" ")) {
            throw new InvalidCommandException("Invalid argument.");
        }
        if (commandArgument.equals("")) {
            return currentDir;
        } else {
            return (currentDir + "\\" + commandArgument);
        }
    }


}
