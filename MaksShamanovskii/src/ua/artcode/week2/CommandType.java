package ua.artcode.week2;

import java.io.*;

public class CommandType implements ICommand {
    @Override
    public String getHelp() {
        return "Show the contents of a text file.\n" +
                "type file_name";
    }

    @Override
    public Object run(String currentPath, String text) throws IOException {
        String path = currentPath + "/" + text;
        if(ConsoleHelper.find(path)){
            if(text.endsWith(".txt")){
                BufferedReader reader = new BufferedReader(new InputStreamReader
                        (new FileInputStream(new File(path))));
                StringBuilder builder = new StringBuilder();
                try {
                    while(reader.ready()){
                        builder.append(reader.readLine()).append("\n");
                    }
                } finally {
                    reader.close();
                }
                System.out.println(builder);
            }
        }
        return currentPath;
    }
}
