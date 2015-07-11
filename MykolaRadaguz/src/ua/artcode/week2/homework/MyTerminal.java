package ua.artcode.week2.homework;

import java.util.Scanner;

/**
 * Created by pikolo on 10.07.15.
 */

/*"Show all available commands - help",
            "ChangeCurrentLocation - cd",
            "Find file(dir) - find",
            "Show directoryContent - dir",
            "Show file (content) - type",
            "Delete file or dir - del , rd",
            "Create dir - mkdir",
            "Create file - touch",
            "Show folder structure - tree",
            "Copy file - cp",
            "Compare content of files - fc" */

public class MyTerminal {
    private static Scanner scanner = new Scanner(System.in);

    public static void commands() {

        String command = new String();

        while (scanner.hasNextLine()){

            command = scanner.nextLine();

        }

        String[] strings;
        strings = command.split(" ");

        if (strings[0].equals("cd")) {
            changeDirectory(strings[1]);
        } else if(strings[0].equals("ls")) {
            listOfFolders(strings[1]);
        } else if (strings[0].equals("help")) {
            showHelp(strings[1]);
        } else if (strings[0].equals("find")) {
            createNewFile(strings[1]);
        } else if (strings[0].equals("dir")) {
            createNewFile(strings[1]);
        } else if (strings[0].equals("type")) {
            createNewFile(strings[1]);
        } else if (strings[0].equals("del")) {
            createNewFile(strings[1]);
        } else if (strings[0].equals("mkdir")) {
            createNewFile(strings[1]);
        } else if (strings[0].equals("touch")) {
            createNewFile(strings[1]);
        } else if (strings[0].equals("tree")) {
            createNewFile(strings[1]);
        } else if (strings[0].equals("cp")) {
            createNewFile(strings[1]);
        } else if (strings[0].equals("fc")) {
            createNewFile(strings[1]);
        } else {
            System.err.printf("There is no such command");
        }

    }

    public static void showHelp (String myString) {

        System.out.println("\"Show all available commands - help\",\n" +
                            "\"ChangeCurrentLocation - cd\",\n" +
                            "\"Find file(dir) - find\",\n" +
                            "\"Show directoryContent - dir\",\n" +
                            "\"Show file (content) - type\",\n" +
                            "\"Delete file or dir - del , rd\",\n" +
                            "\"Create dir - mkdir\",\n" +
                            "\"Create file - touch\",\n" +
                            "\"Show folder structure - tree\",\n" +
                            "\"Copy file - cp\",\n" +
                            "\"Compare content of files - fc\"");

    }

    public static void changeDirectory(String myString) {

        if (myString.equals("")){
        }

    }

    private static void listOfFolders(String myString) {

    }

    private static void deleteFile(String myString) {

    }

    private static void showTree(String myString) {

    }

    private static void copyFile(String myString) {

    }

    private static void createNewFile(String myString) {

    }

    private static void createNewDirectory(String myString) {

    }

    private static void showDirectory(String myString) {

    }

}
