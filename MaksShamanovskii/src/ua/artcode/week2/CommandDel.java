package ua.artcode.week2;

import java.io.File;

public class CommandDel implements ICommand {
    @Override
    public void getHelp() {
        System.out.println("Removes given file or directory.");
        System.out.println("del(rm) directory_name(file_name)");
    }

    @Override
    public Object run(String currentPath, String text) {
        File file = new File(currentPath + "/" + text);
        file.delete();
        return currentPath;
    }
}
