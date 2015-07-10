package ua.artcode.week2;

import java.io.IOException;

public interface ICommand {

    String getHelp();

    Object run(String currentPath, String text) throws IOException;
}
