package ua.artcode.week3.console_menu.remote_console;

import art_code.console_menu.InvalidCommandException;
import art_code.console_menu.commands.*;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Daryna on 13-Jul-15.
 */
public class RemoteCommandConsole {

    private String currentDir = "c:\\Users\\Daryna";
    private static final String ROOT_DIR = "c:\\Users\\Daryna";
    public static final String END_OF_FILE = "EOF";

    private PrintWriter out;
    private BufferedReader in;

    public static String getRootDir() {
        return ROOT_DIR;
    }

    private List<Command> commandList = new ArrayList<>();

    public RemoteCommandConsole(Socket client) throws IOException {
        out = new PrintWriter(client.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(client.getInputStream()));
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


    private void launchCommandConsole() throws IOException {


        sendToClient(out, getAllCommands() + "\n" + currentDir + "\n" + "&");

        while (true) {
            // sendToClient(out, currentDir + "\n" + "&");
            try {
                parseAndRunCommand(in.readLine());
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

        currentDir = command.run(currentDir, argument, out);
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


    public static String getAllCommands() {
        StringBuilder sb = new StringBuilder();
        for (String m : commandNames)
            sb.append(m + "\n");
        return sb.toString();
    }

    private void sendToClient(PrintWriter out, String response) {
        out.println(response + "\nEOF");
    }


}
