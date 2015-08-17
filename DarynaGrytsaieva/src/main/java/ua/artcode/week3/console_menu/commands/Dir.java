package ua.artcode.week3.console_menu.commands;

import ua.artcode.week3.console_menu.CommandUtils;
import ua.artcode.week3.console_menu.InvalidCommandException;

import java.io.File;
import java.io.PrintWriter;

/**
 * Created by Daryna on 13-Jul-15.
 */
public class Dir implements Command {
    private final String COMMAND_NAME = "dir";

    public String getCommandName() {
        return COMMAND_NAME;
    }

    @Override
    public String run(String currentDir, String commandArgument, PrintWriter out) {
        String newDir = getNewDir(currentDir, commandArgument);

        if (CommandUtils.dirExists((newDir))) {
            StringBuilder sb = new StringBuilder();
            File f = new File(newDir);
            File[] files = f.listFiles();
            for (File temp : files) {
                sb.append(temp.getName()+"\n");
               // CommandUtils.sendToClient(out,temp.getName().toString());

            }
            CommandUtils.sendToClient(out,sb.toString());
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
