package ua.artcode.week2;

import ua.artcode.week2.allCommands.*;

import java.io.IOException;
import java.util.*;


/**
 * Created by Олександр on 10.07.2015.
 */
public class Console {

    private String cmd = "c://";
    private Scanner scanner = new Scanner(System.in);
    private boolean work = true;


    public Console(){
        run();
    }

    private void run(){
        while (work){
            System.out.println(cmd + "$ ");
            String text = scanner.nextLine();
            checkText(text);
        }
    }

    private void checkText(String text)  {
        String[] line  = text.trim().split("\\s");
        String command = line[0];
        String param = "";
        if(line.length > 1)
            param = line[1];
        if(command.equalsIgnoreCase("cd")){
            commandsRun(new CommandCd(), param);
        }else if(command.equalsIgnoreCase("dir") || command.equalsIgnoreCase("ls")){
            commandsRun(new CommandDir(), param);
        }else if(command.equalsIgnoreCase("find")){
            commandsRun(new CommandFind(), param);
        }else if(command.equalsIgnoreCase("help")){
            commandsRun(new CommandHelp(), param);
        }else if(command.equalsIgnoreCase("mkdir")){
            commandsRun(new CommandMkdir(), param);
        }else if(command.equalsIgnoreCase("mkf")){
            commandsRun(new CommandMkf(), param);
        }else if(command.equalsIgnoreCase("del") || command.equalsIgnoreCase("rm")){
            commandsRun(new CommandDel(), param);
        }else if(command.equalsIgnoreCase("tree")){
            commandsRun(new CommandTree(), param);
        }



    }




    private void commandsRun(Commands command, String param)  {
        try {
            cmd = (String) command.run(cmd, param);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

}












