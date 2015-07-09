package ua.artcode.week2;

import java.io.File;

public class CommandTree implements ICommand {
    @Override
    public String getHelp() {
        return null;
    }

    @Override
    public Object run(String currentPath, String text) {
        if(text.equals("")){
            tree(currentPath);
        }else{
            tree(currentPath + "/" + text);
        }
        return currentPath;
    }

    private void tree(String current){
        File file = new File(current);
        File[] files = file.listFiles();
        String temp = "";
        for (File f : files) {
            if (files == null) {
                return;
            }
            System.out.println(temp + f.getName());
            temp = temp + " ";
            if (f.isDirectory()) {
                tree(f.getPath());
            }
        }
    }
}
