package ua.artcode.week2;

import java.io.File;

public class CommandTree implements ICommand {
    private String temp = "";

    @Override
    public String getHelp() {
        return "Produces a depth indented listing of files.\n" +
                "tree [directory_name]";
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
        for (File f : files) {
            if (files == null) {
                return;
            }
            if(!f.getName().startsWith(".")){
                String name = f.getName();
                System.out.println(temp + name);
            }
            if (f.isDirectory()) {
                temp = temp + " ";
                tree(f.getPath());
            }
        }
    }
}
