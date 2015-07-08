package ua.artcode.week2;

import java.io.File;
import java.io.IOException;

public class CommandMkf implements ICommand{
    @Override
    public String getHelp() {
        return "Creates files with the specified names.\n" +
                "mkf file_name";
    }

    @Override
    public Object run(String currentPath, String text) {
        File file = new File(currentPath + "/" + text);
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return currentPath;
    }
}
