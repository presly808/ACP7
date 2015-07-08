package ua.artcode.week2;

import java.io.File;
import java.io.IOException;

public class CommandMkf implements ICommand{
    @Override
    public void getHelp() {
        System.out.println("Creates files with the specified names.");
        System.out.println("mkf file_name");
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
