package ua.artcode.week2.commands_v2.commands;

import ua.artcode.utils.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 * Created by boris on 7/10/15.
 */
public class Touch extends Command {
    private final String NAME = "touch";


    @Override
    public void execute() throws IOException {
        if (isHelp(getFilters())) {
            showHelp();
        } else if (getParams().size() == 1) {
            String path = getParams().get(0);
            FileUtils.createFile(path);
        } else {
            throw new IOException("Command: "+ NAME +" Get Incorrect params!!!");
        }
    }

    @Override
    public void showHelp() {
        System.out.printf("Command: '%s'. Use for creating file.\n", NAME);
        System.out.println("Example : dir or touch <dir_path/file_name>");
        System.out.println("for help use filter '-h'");

    }

    @Override
    public String getName() {
        return NAME;
    }
}
