package ua.artcode.week2;

public class CommandTree implements ICommand {
    @Override
    public void getHelp() {

    }

    @Override
    public Object run(String currentPath, String text) {

        return currentPath;
    }
}
