package ua.artcode.week2;

import java.io.File;

public class CommandMkdir implements ICommand {
    @Override
    public String getHelp() {
        return "Creates directories with the specified names.\n" +
                "mkdir directory_name";
    }

    @Override
    public Object run(String currentPath, String text) {
        File file = new File(currentPath + "/" + text);
        file.mkdir();
        return currentPath;
    }
}
