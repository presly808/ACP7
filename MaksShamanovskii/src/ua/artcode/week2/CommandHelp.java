package ua.artcode.week2;

public class CommandHelp implements ICommand{

    @Override
    public String getHelp() {
        return "Display information about builtin commands.\n" +
                "cd - Change the shell working directory.\n" +
                "find - Searches the directory tree rooted.\n" +
                "dir - Display the list of currently remembered directories.\n" +
                "ls - Display the list of currently remembered directories.\n" +
                "mkdir - Creates directories with the specified names.\n" +
                "mkf - Creates files with the specified names.\n" +
                "del - Removes given file or directory.\n" +
                "rm - Removes given file or directory.\n" +
                "tree - Produces a depth indented listing of files.\n" +
                "type - Show the contents of a text file.\n";
    }

    @Override
    public Object run(String currentPath, String text) {
        if(text.equalsIgnoreCase("cd")){
            help(new CommandCd());
        }else if(text.equalsIgnoreCase("dir") || text.equalsIgnoreCase("ls")) {
            help(new CommandDir());
        }else if(text.equalsIgnoreCase("find")) {
            help(new CommandFind());
        }else if(text.equalsIgnoreCase("help") || text.equalsIgnoreCase("")) {
            System.out.println(getHelp());
        }else if(text.equalsIgnoreCase("mkdir")) {
            help(new CommandMkdir());
        }else if(text.equalsIgnoreCase("mkf")) {
            help(new CommandMkf());
        }else if(text.equalsIgnoreCase("tree")) {
            help(new CommandTree());
        }else if(text.equalsIgnoreCase("del") || text.equalsIgnoreCase("rm")) {
            help(new CommandDir());
        }else if(text.equalsIgnoreCase("type")) {
            help(new CommandType());
        }
        return currentPath;
    }

    private void help(ICommand command){
        System.out.println(command.getHelp());
    }


}
