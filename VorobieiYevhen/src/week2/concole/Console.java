package week2.concole;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Джек on 11.07.2015.
 */
public class Console {
    private static String PATH = "C:\\Users\\Джек\\GIT_SIMPLE\\ACP7\\VorobieiYevhen\\";
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


    public Console() {


    }
    public  void window() {
        MyFileHelper fileHelper = new MyFileHelper(new File(PATH));

        while (true) {

            System.out.println("\nSelect menu operation (Press \"Enter\" to exit).");
            System.out.print(PATH + " > ");

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
                case "help":
                    fileHelper.help();
                    break;
                case "dir":
                    fileHelper.dir();
                    break;
                case "mkdir":
                    fileHelper.mkdir();
                    break;
                case "find":
                    fileHelper.find();
                    break;
                default:
                    System.out.println("No such command. View \"Help menu\" - \"help\"");
                    break;

            }
        }
    }
}
    


