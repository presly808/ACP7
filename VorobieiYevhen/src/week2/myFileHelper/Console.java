package week2.myFileHelper;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Джек on 11.07.2015.
 */
public class Console {
    private static String PATH = "D:/";
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


    public Console() {


    }
    public  void window() {
        MyFileHelper fileHelper = new MyFileHelper(new File(PATH));

        while (true) {

            System.out.println("\n\nSelect menu operation (\"Enter\" to exit).");
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
                default:
                    System.out.println("No such command. View \"Help menu\" - \"help\" or press \"Esc\" to exit");
                    break;

            }
        }
    }
}
    


