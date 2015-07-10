package ua.artcode.week2.commands_v2.commands;

import ua.artcode.utils.FileUtils;

import java.io.IOException;

/**
 * Created by boris on 7/9/15.
 */
public class Cd extends Command {
    private final String NAME = "cd";
    public Cd(){
        super();
    }

    public Cd(String command) {
        super(command);
    }

    @Override
    public void execute() throws IOException {
        if (isHelp(getFilters())) {
            showHelp();
        }
        if (getParams().size() == 1) {
            String dPath = getParams().get(0);
            setFile(FileUtils.changeLocation(dPath));

        } else {
            throw new IOException("Incorrect params!!!");
        }
    }


    public void showHelp() {
        System.out.printf("Command: %s change yor locations\n", NAME);
        System.out.println("Use filter '-h' for getting help");
    }

    @Override
    public String getName() {
        return NAME;
    }
}
