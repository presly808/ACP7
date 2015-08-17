package ua.artcode.week2.fileHelper;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.SocketHandler;

/**
 * Created by tokar on 09.07.2015.
 */
public class FileHelperTest {
    public static String PATH = "D:/";

    public static void main(String[] args) {

        FileHelper fileHelper = new FileHelper();
        File ourFile = new File(PATH);
        System.out.println(ourFile.getAbsolutePath() + ">");


        while (true) {

            System.out.println("Enter command");
            Scanner sc = new Scanner(System.in);
            String com = sc.nextLine();
            String[] commands = com.split(" ");
            if (commands[0].equals("cd")) {
                ourFile = fileHelper.changeCurrentLocation(commands[1]);
                System.out.println(ourFile.getPath() + ">");
            }
            if(commands[0].equals("help")){
                fileHelper.showAllCommands();
            }
            if(commands[0].equals("dir")){
                fileHelper.dir(commands[1]);
            }
            if (commands[0].equals("find")){

                try {
                   String finded=  fileHelper.find(commands[1], ourFile);
                    System.out.println(finded);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }

            }
            if (commands[0].equals("exit")) {
                return;
            }

        }

    }
}
