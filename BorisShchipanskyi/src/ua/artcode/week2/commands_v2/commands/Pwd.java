package ua.artcode.week2.commands_v2.commands;

import ua.artcode.utils.FileUtils;

import java.io.IOException;

/**
 * Created by boris on 7/9/15.
 */
public class Pwd extends Command {
    private final String NAME = "pwd";
    private final String fullFilter = "-f";

    public Pwd() {
        super();
    }

    public Pwd(String command) {
        super(command);
    }

    @Override
    public void execute() throws IOException {
        String path = "";
        if (isHelp(getFilters())) {
            showHelp();
        } else if (getFilters().size() != 0) {
            if (getFilters().contains(fullFilter)) {
                path = FileUtils.getAbsolutePath(getFile());

            }
        }else {
            path = FileUtils.getPath(getFile());
            }
            System.out.println("You location: " + path);
    }



    public void showHelp() {
        System.out.printf("Command: %s show you location\n", NAME);
        System.out.println("Use filtee '-f' for getting absolute lacations");
    }

    @Override
    public String getName() {
        return NAME;
    }
}
