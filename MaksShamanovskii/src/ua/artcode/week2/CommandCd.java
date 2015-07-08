package ua.artcode.week2;

public class CommandCd implements ICommand {
    @Override
    public String getHelp() {
        return "Change the shell working directory.\n" +
                "`..' is processed by removing the immediately previous pathname component\n" +
                "back to a slash or the beginning of DIR.\n" +
                "cd directory_name";
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
