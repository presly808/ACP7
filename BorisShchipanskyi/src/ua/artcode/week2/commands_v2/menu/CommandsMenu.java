package ua.artcode.week2.commands_v2.menu;

import ua.artcode.week2.commands_v2.Command;
import ua.artcode.week2.commands_v2.Cp;
import ua.artcode.week2.commands_v2.ICommand;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by boris on 7/9/15.
 */
public class CommandsMenu {
    List<String> commandNames;
    Scanner lineScan = new Scanner(System.in);


    public CommandsMenu() {
        initNames();
        run();
    }

    private void run() {
        shayHello();
        String line = getLine();
        while (!line.equals("0")) {
            if (line.equals("1")) {
                showAllCommands();
            } else {
                Command command = new Cp(line);
                try {
                    command.execute();
                }catch (IOException e){
                    System.out.println("Cannot execute! "+ e.getMessage());
                }

            }
        shayHello();
            line = getLine();
        }

    }


    private void initNames() {
        commandNames = new ArrayList<>();
        commandNames.add("cp");
    }

    private void showAllCommands() {
        System.out.println("Commands:");
        for (String command : commandNames) {
            System.out.println(command);
        }
    }

    private void shayHello() {
        System.out.println("You are in FileHelper.");
        System.out.println("press 1 - for get all commands list");
        System.out.println("press 0 - for exit");
        System.out.println("enter your command:");

    }

    private String getLine() {
        return lineScan.nextLine();
    }
}
