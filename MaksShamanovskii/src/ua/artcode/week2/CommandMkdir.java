package ua.artcode.week2;

import java.io.File;

public class CommandMkdir implements ICommand {
    @Override
    public void getHelp() {
        System.out.println("Creates directories with the specified names.");
        System.out.println("mkdir directory_name");
    }

    @Override
    public Object run(String currentPath, String text) {
        File file = new File(currentPath + "/" + text);
        file.mkdir();
        return currentPath;
    }
}
