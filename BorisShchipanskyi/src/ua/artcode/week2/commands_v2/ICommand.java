package ua.artcode.week2.commands_v2;

import java.io.IOException;

/**
 * Created by boris on 7/9/15.
 */
public interface ICommand {

    public abstract void execute() throws IOException;
    public abstract void showHelp();
    public abstract String getName();


}
