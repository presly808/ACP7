package ua.artcode.week2.console_menu.simple_console;

import art_code.console_menu.InvalidCommandException;
import art_code.console_menu.commands.*;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Daryna on 13-Jul-15.
 */
public class CommandConsole {

    Scanner scan = new Scanner(System.in);
    private String currentDir = "c:\\Users\\Daryna";
    private static final String ROOT_DIR = "c:\\Users\\Daryna";

    public static String getRootDir() {
        return ROOT_DIR;
    }

    private List<Command> commandList = new ArrayList<>();

    public CommandConsole() {
        initCommandConsole();
        launchCommandConsole();
    }

    private void initCommandConsole() {
        commandList.add(new Cd());
        commandList.add(new Dir());
        commandList.add(new Help());
        commandList.add(new Tree());
        commandList.add(new Exit());
        commandList.add(new Type());
        commandList.add(new Find());
        commandList.add(new Del());
        commandList.add(new Rd());
        commandList.add(new Mkdir());
        commandList.add(new Mkf());
//        commandList.add(new Copy());
//        commandList.add(new Fc());

    }

    private void launchCommandConsole() {
        printAllCommands();
        while (true) {
            System.out.print(currentDir + "\n" + "&");
            try {
                parseAndRunCommand(scan.nextLine());
            } catch (InvalidCommandException e) {
                e.printStackTrace();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    private void parseAndRunCommand(String input) throws FileNotFoundException {
        input = input.trim();
        String[] commandAndArguments = input.split(" ", 0);
        String commandName = commandAndArguments[0];
        String argument = "";
        if (commandAndArguments.length > 1) {
            argument = commandAndArguments[1];
        }

        runCommand(commandName, argument);
    }


    private void runCommand(String commandName, String argument) throws FileNotFoundException {
        Command command = null;
        for (Command iter : commandList) {
            if (commandName.equalsIgnoreCase(iter.getCommandName())) {
                command = iter;
            }
        }
        if (command == null) {
            throw new InvalidCommandException("Invalid command.");
        }

        currentDir = command.run(currentDir, argument);
    }

    private static String[] commandNames = {"Show all available commands - help",
            "Change current location - cd",
            "Show directory content - dir",
            "Show folder structure - tree",
            "Show file (content) - type",
            "Find file(dir) - find",
            "Delete file or dir - del , rd",
            "Create dir - mkdir",
            "Create file - mkf",
            "Copy file - copy",
            "Compare content of files - fc",
            "Exit - exit"};


    public static void printAllCommands() {
        for (String m : commandNames)
            System.out.println(m);

    }

}
