package ua.artcode.week2;

import java.util.*;


/**
 * Created by Олександр on 10.07.2015.
 */
public class Cmd {
    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Cmd cmd = new Cmd();
        cmd.promt("c://");
        cmd.readUserCommand();
    }

    public void readUserCommand() {
        String inputCommand = scanner.nextLine();
        String[] commandWithParam = inputCommand.trim().split("\\s+");
        String command = commandWithParam[0];
        for(Commands commandFromEnum: Commands.values()) {
            if (commandFromEnum.getCommandName().equals(command)) {
                commandFromEnum.executeCommand("some param");
            }
        }
    }


    private void promt(String promt) {
        System.out.println(promt);
    }



}









