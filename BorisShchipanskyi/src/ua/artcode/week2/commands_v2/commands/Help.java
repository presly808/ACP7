package ua.artcode.week2.commands_v2.commands;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by boris on 7/10/15.
 */
public class Help extends Command {
    private final String NAME = "help";
    List<ICommand> commands;
    private final String fullFilter = "-f";

    public Help() {
        super();
    }

    public Help(String command) {
        super(command);
        initCommands();
    }

    private void initCommands() {
        commands = new ArrayList<>();
        commands.add(new Cp());
        commands.add(new Cd());
        commands.add(new Help());
        commands.add(new Pwd());
        commands.add(new Find());
        commands.add(new Dir());
        commands.add(new Type());
        commands.add(new Mkdir());
        commands.add(new Touch());
        commands.add(new Rm());
//        commands.add();


    }

    public List<ICommand> getCommands() {
        return commands;
    }

    @Override
    public void execute() throws IOException {
        initCommands();
        if (isHelp(getFilters())) {
            showHelp();
        }
        if (getFilters().size() != 0) {
            if (getFilters().contains(fullFilter)) {
                showFull();
            }
        } else {
            showSimple();
        }
    }

    public void showSimple() {
        System.out.println("You can use next commands:");
        for (ICommand com : commands) {
            System.out.printf("Command: %s\n", com.getName());
        }
    }

    private void showFull() {
        for (ICommand com : commands) {
            com.showHelp();
        }
    }

    @Override
    public void showHelp() {
        System.out.println("Command help: for show simple help enter 'help'");
        System.out.println("For get more information, use 'help -f'");
        System.out.println("Use filter '-h' for getting help");
    }

    @Override
    public String getName() {
        return NAME;
    }
}
