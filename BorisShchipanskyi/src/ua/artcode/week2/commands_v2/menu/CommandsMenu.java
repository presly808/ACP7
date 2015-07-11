package ua.artcode.week2.commands_v2.menu;

import ua.artcode.week2.commands_v2.command_utils.CommandUtils;
import ua.artcode.week2.commands_v2.commands.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by boris on 7/9/15.
 */
public class CommandsMenu {
    Help help = new Help("help");
    Scanner lineScan = new Scanner(System.in);
    File file = new File(".");

    public CommandsMenu() {
        run();
    }

    private void run() {
        shayHello();
        String line = getLine();
        while (!line.equals("0")) {
            if (line.equals("1")) {
                shayHello();
            } else {
                Command command ;
                try {
                    command = getCommand(line);
                        command.execute();
                    if(command instanceof Cd){
                        file = command.getFile();
                    }
                }catch (IOException e){
                    System.out.println("Cannot execute! "+ e.getMessage());
                }

            }
        shayHello();
            line = getLine();
        }

    }


    private void shayHello() {
        System.out.println("You are in FileHelper.");
        System.out.println("press 0 - for exit");
        System.out.println("enter 'help' for more information");

    }

    private String getLine() {
        return lineScan.nextLine();
    }

    private Command getCommand(String line)throws IOException{
        String newCommand = CommandUtils.getCommand(line);
        Command myCommand;
        for(ICommand com: help.getCommands()){
            if(newCommand.equals(com.getName())){
                myCommand = (Command) com;
                myCommand.setCommand(line);
                myCommand.setFile(file);
                return myCommand;

            }
        }
        throw new IOException(line);
    }


}
