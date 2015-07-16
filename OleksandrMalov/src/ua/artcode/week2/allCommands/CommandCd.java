package ua.artcode.week2.allCommands;

/**
 * Created by Олександр on 15.07.2015.
 */
public class CommandCd implements Commands {
    @Override
    public String getHelp() {
        return "cd directory_name\n" +
               "Change the shell working directory.\n" +
                "'..' is processed by removing the previous pathname component\n" +
                "back to a slash or the beginning of DIR.\n";
    }

    @Override
    public Object run(String currentPath, String param) {
        if(param.equals("")){
            return currentPath.substring(0, currentPath.length());
        }
        if (param.equals("..")) {
            int index = currentPath.lastIndexOf("/");
            return currentPath.substring(0, index);
        }
        String newPath = currentPath + "/" + param;
        if (ConsoleHelper.find(newPath)) {
            currentPath = newPath;
        }
        return currentPath;
    }




}
