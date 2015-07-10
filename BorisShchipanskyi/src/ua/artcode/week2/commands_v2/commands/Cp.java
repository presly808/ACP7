package ua.artcode.week2.commands_v2.commands;

import ua.artcode.utils.FileUtils;

import java.io.IOException;

/**
 * Created by boris on 7/9/15.
 */
public class Cp extends Command {
    private final String NAME = "cp";

    public Cp(){
        super();
    }
    public Cp(String command) {
        super(command);
    }

    @Override
    public void execute() throws IOException {
        if (isHelp(getFilters())) {
            showHelp();
        }
        if (getParams().size() == 2 && FileUtils.isFile(getParams().get(0))) {
            String sPath = getParams().get(0);
            String dPath = getParams().get(1);
            FileUtils.copy(sPath, dPath);

        } else {
            throw new IOException("Incorrect params!!!");
        }
    }


    public void showHelp() {
        System.out.printf("Command: %s can copy file from <File1> to <File2>  or to <Dir2>\n", NAME);
        System.out.println("Use filter '-h' for getting help");
    }

    @Override
    public String getName() {
        return NAME;
    }
}
