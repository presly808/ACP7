package ua.artcode.week3.console_menu.commands;

import art_code.console_menu.CommandUtils;
import art_code.console_menu.InvalidCommandException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * Created by Daryna on 14-Jul-15.
 */
public class Rd implements Command {
    private final String COMMAND_NAME = "rd";

    @Override
    public String getCommandName() {
        return COMMAND_NAME;
    }


    @Override
    public String run(String currentDir, String commandArgument, PrintWriter out) throws FileNotFoundException {
        String newDir = getNewDir(currentDir, commandArgument);

        if (CommandUtils.dirExists(newDir)) {
            File dir = new File(newDir);
            if (deleteDir(dir)) ;
            {
               CommandUtils.sendToClient(out,"Directory deleted.");
            }
        }


        return currentDir;
    }

    private boolean deleteDir(File dir) {
        if (dir.isDirectory()) {
            File[] dirFiles = dir.listFiles();
            for (int i = 0; i < dirFiles.length; i++) {
                if (dirFiles[i].isDirectory()) {
                    deleteDir(dirFiles[i]);
                } else {
                    dirFiles[i].delete();
                }
            }

        }
        return dir.delete();


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
