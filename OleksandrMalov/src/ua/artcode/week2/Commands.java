package ua.artcode.week2;

/**
 * Created by Олександр on 10.07.2015.
 */
public enum Commands {
    CD("cd") {
        @Override
        String executeCommand(String param) {

            return null;
        }
    },DIR("dir") {
        @Override
        String executeCommand(String param) {
            return null;
        }
    },HELP("help") {
        @Override
        String executeCommand(String param) {
            return null;
        }
    };

    Commands(String commandName) {
        this.commandName = commandName;
    }

    private String commandName;
    abstract String executeCommand(String param);
    String getCommandName(){
        return commandName;
    }
}
