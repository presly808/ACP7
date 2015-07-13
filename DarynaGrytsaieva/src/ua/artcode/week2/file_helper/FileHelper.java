package ua.artcode.week2.file_helper;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by Daryna on 08-Jul-15.
 */
public class FileHelper {
    String command;
    String argument;

    private static String[] commandNames = {"Show all available commands - help",
            "ChangeCurrentLocation - cd",
            "Find file(dir) - find",
            "Show directoryContent - dir",
            "Show file (content) - type",
            "Delete file or dir - del , rd",
            "Create dir - mkdir",
            "Create file - mkf",
            "Show folder structure - tree",
            "Copy file - copy",
            "Compare content of files - fc"};

    public void launchFileHelper() throws IOException {
        printMenu();

        while (true) {
            String input = someReader();
            parse(input);

            switch (command) {
                case "help":
                    help();
                    break;
                case "cd":
                    cd(argument);
                    break;
                case "find":
                    find(argument);
                    break;
                case "dir":
                    dir();
                    break;
                case "type":
                    type();
                    break;
                case "del":
                    del(argument);
                    break;
                case "rd":
                    rd(argument);
                    break;
                case "mkdir":
                    mkdir(argument);
                    break;
                case "mkf":
                    mkf(argument);
                    break;
                case "tree":
                    tree();
                    break;
                case "copy":
                    copy(argument);
                    break;
                case "fc":
                    fc();
                    break;

            }
        }

    }

    public static void printMenu() {
        for (String m : commandNames)
            System.out.println(m);
    }

    private String someReader() {

        InputStream inputStream = System.in;
        Reader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader reader = new BufferedReader(inputStreamReader);

        // or BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = null;
        try {
            input = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return input;
    }

    private void parse(String input) throws IOException {
        StringTokenizer st = new StringTokenizer(input, " ");
        if (st.countTokens() > 2) {
            throw new IOException("Illegal command input."); //????????
        }
        command = st.nextToken();
        if (st.hasMoreTokens()) {
            argument = st.nextToken();
        }

    }


    private static void help() {
        printMenu();
    }

    //ChangeCurrentLocation
    private static void cd(String path) {

    }

    //Find file(dir)
    private static void find(String fileName) {

    }

    //Show directoryContent
    private static void dir() {

    }

    //Show file (content)
    private static void type() {

    }

    //Delete file
    private static void del(String fileName) {

    }

    //Delete dir
    private static void rd(String dirName) {

    }

    //Create dir
    private static void mkdir(String dirName) {

    }

    //Create file
    private static void mkf(String fileName) {

    }

    //Show folder structure
    private static void tree() {

    }

    //Copy file
    private static void copy(String fileName) {

    }

    //Compare content of files
    private static void fc() {

    }

}
