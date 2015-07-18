package week2.concole;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;


public class Console {
    private static String PATH = "C:\\Users\\Джек\\GIT_SIMPLE\\ACP7\\VorobieiYevhen\\resources\\";
    private String currentPath = PATH;
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


    public Console() {


    }



    public void window() {


        while (true) {
            MyFileHelper fileHelper = new MyFileHelper(new File(currentPath));
            System.out.println("\nEnter menu (\"help\") operation (Press \"Enter\" to exit).");
            System.out.print(currentPath + " > ");

            String select = null;

                try {
                    select = br.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (select.isEmpty()) {
                    break;
                }

            switch (select.toLowerCase()) {
                case "cd":
                    String newPath = fileHelper.cd();
                    currentPath = newPath != null ? newPath : PATH;

                    break;
                case "help":
                    fileHelper.help();
                    break;
                case "dir":
                    fileHelper.dir();
                    break;
                case "tree":
                    fileHelper.tree();
                    break;
                case "mkdir":
                    fileHelper.mkdir();
                    break;
                case "mkfile":
                    fileHelper.mkfile();
                    break;
                case "del":
                    fileHelper.del();
                    break;
                case "find":
                    fileHelper.find();
                    break;
                case "type":
                    fileHelper.type();
                    break;
                default:
                    System.out.println("No such command. View \"Help menu\" - \"help\"");
                    break;

            }
        }
    }
}
    


