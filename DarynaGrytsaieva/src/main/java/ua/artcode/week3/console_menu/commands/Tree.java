package ua.artcode.week3.console_menu.commands;

import art_code.console_menu.CommandUtils;
import art_code.console_menu.InvalidCommandException;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Daryna on 13-Jul-15.
 */
public class Tree implements Command {
    private final String COMMAND_NAME = "tree";

    public String getCommandName() {
        return COMMAND_NAME;
    }

    @Override
    public String run(String currentDir, String commandArgument, PrintWriter out) {
        String newDir = getNewDir(currentDir, commandArgument);

        if (CommandUtils.dirExists(newDir)) {
            File f = new File(newDir);
            List<File> files = new ArrayList();
            File[] temp = f.listFiles();
            for (File ff : temp) {
                files.add(ff);
            }
            while (!files.isEmpty()) {
                if (files.get(0).isDirectory()) {
                    CommandUtils.sendToClient(out, "-" + files.get(0).getName());
                    for (File ff : files.get(0).listFiles())
                        files.add(ff);
                }
                files.remove(0);
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
            return (currentDir + "/" + commandArgument);
        }
    }
}
