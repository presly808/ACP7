package ua.artcode.week3.console_menu.commands;

import ua.artcode.week3.console_menu.CommandUtils;
import ua.artcode.week3.console_menu.InvalidCommandException;

import java.io.PrintWriter;

/**
 * Created by Daryna on 13-Jul-15.
 */
public class Cd implements Command {
    private final String COMMAND_NAME = "cd";


    public String getCommandName() {
        return COMMAND_NAME;
    }

    @Override
    public String run(String currentDir, String commandArgument, PrintWriter out) {
        String newDir = getNewDir(currentDir, commandArgument);


        if (CommandUtils.dirExists(newDir)) {
            CommandUtils.sendToClient(out,newDir);
            return newDir;
        }

        int index = newDir.lastIndexOf("\\");
        CommandUtils.sendToClient(out,newDir.substring(0, index));
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
