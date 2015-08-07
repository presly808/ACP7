package ua.artcode.week3.console_menu.commands;

import ua.artcode.week3.console_menu.CommandUtils;
import ua.artcode.week3.console_menu.InvalidCommandException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Created by Daryna on 14-Jul-15.
 */
public class Find implements Command {
    private final String COMMAND_NAME = "find";


    @Override
    public String getCommandName() {
        return COMMAND_NAME;
    }

    @Override
    public String run(String currentDir, String commandArgument, PrintWriter out) throws FileNotFoundException {
        String searchDir = getSearchDir(currentDir, commandArgument);
        File rootFile = new File(searchDir);

        CommandUtils.sendToClient(out,"---" + find(rootFile, commandArgument) );


        return currentDir;

    }


    private String find(File file, String fileName) {
        ArrayList<File> files = new ArrayList<File>();
        File[] temp = file.listFiles();
        for (File ff : temp) {
            files.add(ff);
        }
        String path = null;
        while (!files.isEmpty()) {
            if (files.get(0).getName().equals(fileName)) {
                path = files.get(0).getPath();
            }
            if (files.get(0).isDirectory()) {

                for (File ff : files.get(0).listFiles())
                    files.add(ff);
            }
            files.remove(0);
        }
        return path == null ? "File/dir not found." : path;


    }

    private String getSearchDir(String currentDir, String commandArgument) {

        if (commandArgument.contains(" ") || commandArgument.isEmpty()) {
            throw new InvalidCommandException("Invalid argument.");

        } else {
            //return CommandConsole.getRootDir();
            return currentDir;
        }
    }

}
