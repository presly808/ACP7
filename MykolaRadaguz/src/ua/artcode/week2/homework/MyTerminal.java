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

    public void commands() {

        String command = new String();

        while (scanner.hasNextLine()){

            command = scanner.nextLine();

        }

        String[] strings;
        strings = command.split(" ");

        String enteredCommand = strings[0];
        String argumentCommand = strings[1];

        if (enteredCommand.equals("cd")) {
            changeDirectory(argumentCommand);
        } else if(enteredCommand.equals("ls")) {
            listOfFolders(argumentCommand);
        } else if (enteredCommand.equals("help")) {
            showHelp(argumentCommand);
        } else if (enteredCommand.equals("find")) {
            createNewFile(argumentCommand);
        } else if (enteredCommand.equals("type")) {
            createNewFile(argumentCommand);
        } else if (enteredCommand.equals("del")) {
            deleteFile(argumentCommand);
        } else if (enteredCommand.equals("mkdir")) {
            createNewDirectory(argumentCommand);
        } else if (enteredCommand.equals("touch")) {
            createNewFile(argumentCommand);
        } else if (enteredCommand.equals("tree")) {
            showTree(argumentCommand);
        } else if (enteredCommand.equals("cp")) {
            copyFile(argumentCommand);
        } else if (enteredCommand.equals("fc")) {
            compareFiles(argumentCommand);
        } else {
            System.err.printf("There is no such command");
        }

    }

    public static void showHelp (String myString) {

        System.out.println("\"Show all available commands - help\",\n" +
                            "\"ChangeCurrentLocation - cd\",\n" +
                            "\"Find file(dir) - find\",\n" +
                            "\"List directory content - ls\",\n" +
                            "\"Show file (content) - type\",\n" +
                            "\"Delete file or dir - del\",\n" +
                            "\"Create dir - mkdir\",\n" +
                            "\"Create file - touch\",\n" +
                            "\"Show folder structure - tree\",\n" +
                            "\"Copy file - cp\",\n" +
                            "\"Compare content of files - fc\"");

    }

    public void changeDirectory(String myString) {

        if (myString.equals("")){
        }

    }

    private void listOfFolders(String myString) {

    }

    private void deleteFile(String myString) {

    }

    private void showTree(String myString) {

    }

    private void copyFile(String myString) {

    }

    private void createNewFile(String myString) {

    }

    private void createNewDirectory(String myString) {

    }

    private void compareFiles(String myString) {

    }

}
