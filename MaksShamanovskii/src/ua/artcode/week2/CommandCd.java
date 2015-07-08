package ua.artcode.week2;

public class CommandCd implements ICommand {
    @Override
    public void getHelp() {
        System.out.println("Change the shell working directory.");
        System.out.println("`..' is processed by removing the immediately previous pathname component");
        System.out.println("back to a slash or the beginning of DIR.");
        System.out.println("cd directory_name");
    }

    @Override
    public Object run(String currentPath, String text) {
        if(text.equals("")){
            return currentPath.substring(0, currentPath.length());
        }
        if (text.equals("..")) {
            int index = currentPath.lastIndexOf("/");
            return currentPath.substring(0, index);
        }
        String newPath = currentPath + "/" + text;
        if (ConsoleHelper.find(newPath)) {
            currentPath = newPath;
        }
        return currentPath;
    }
}
