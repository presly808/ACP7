package ua.artcode.week2;

import java.io.File;

public class CommandDel implements ICommand {
    @Override
    public String getHelp() {
        return "Removes given file or directory.\n" +
                "del(rm) directory_name(file_name)";
    }

    @Override
    public Object run(String currentPath, String text) {
        File file = new File(currentPath + "/" + text);
        file.delete();
        return currentPath;
    }
}
