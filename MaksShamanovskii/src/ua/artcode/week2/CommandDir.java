package ua.artcode.week2;

import java.io.File;

public class CommandDir implements ICommand {
    @Override
    public String getHelp() {
        return "Display the list of currently remembered directories.\n" +
                "dir [directory_name]";
    }

    @Override
    public Object run(String currentPath, String text) {
        if(!text.equals("")){
            currentPath = currentPath + "/" + text;
        }
        File file = new File(currentPath);
        File[] files = file.listFiles();
        for (int i = 0; i < files.length; i++) {
            if(!files[i].getName().startsWith(".")) {
                System.out.println(files[i].getName());
            }
        }
        return currentPath;
    }
}
