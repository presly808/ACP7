package ua.artcode.week3.console_menu.commands;

import ua.artcode.week3.console_menu.CommandUtils;
        import ua.artcode.week3.console_menu.InvalidCommandException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Daryna on 14-Jul-15.
 */
public class Mkf implements Command {
    private final String COMMAND_NAME = "mkf";

    @Override
    public String getCommandName() {
        return COMMAND_NAME;
    }

    @Override
    public String run(String currentDir, String commandArgument, PrintWriter out) throws FileNotFoundException {
        String newDir = getNewDir(currentDir, commandArgument);

        if (CommandUtils.fileExists(newDir)) {
            CommandUtils.sendToClient(out, "File already exists.");

        } else {
            File file = new File(newDir);
            try {
                file.createNewFile();
                CommandUtils.sendToClient(out, "File " + file.getName() + " created.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return currentDir;

    }

    private String getNewDir(String currentDir, String commandArgument) {

        if (commandArgument.contains(" ") || commandArgument.equals("")) {
            throw new InvalidCommandException("Invalid argument.");

        } else {
            return (currentDir + "/" + commandArgument);
        }
    }

}
