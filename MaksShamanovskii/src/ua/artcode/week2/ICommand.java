package ua.artcode.week2;

public interface ICommand {

    String getHelp();

    Object run(String currentPath, String text);
}
