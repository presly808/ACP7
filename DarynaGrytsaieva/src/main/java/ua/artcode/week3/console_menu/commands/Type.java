package ua.artcode.week3.console_menu.commands;

import art_code.console_menu.CommandUtils;
import art_code.console_menu.InvalidCommandException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by Daryna on 14-Jul-15.
 */
public class Type implements Command {
    private final String COMMAND_NAME = "type";

    @Override
    public String getCommandName() {
        return COMMAND_NAME;
    }

    @Override
    public String run(String currentDir, String commandArgument, PrintWriter out) throws FileNotFoundException {
        String newDir = getNewDir(currentDir, commandArgument);

        if (CommandUtils.fileExists(newDir)) {
            File f = new File(newDir);
            Scanner scan = new Scanner(f);
            StringBuilder sb = new StringBuilder();
            while (scan.hasNextLine()) {
                sb.append(scan.nextLine() + "\n");
            }
            CommandUtils.sendToClient(out, sb.toString());
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
