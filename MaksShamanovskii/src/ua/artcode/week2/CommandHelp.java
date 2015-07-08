package ua.artcode.week2;

public class CommandHelp implements ICommand{


    @Override
    public void getHelp() {
        System.out.println("Display information about builtin commands.");
        System.out.println("cd - Change the shell working directory.");
        System.out.println("find - Searches the directory tree rooted");
        System.out.println("dir - Display the list of currently remembered directories.");
        System.out.println("ls - Display the list of currently remembered directories.");
        System.out.println("mkdir - Creates directories with the specified names.");
        System.out.println("mkf - Creates files with the specified names.");
        System.out.println("del - Removes given file or directory.");
        System.out.println("rm - Removes given file or directory.");

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
            getHelp();
        }
        return currentPath;
    }

    private void help(ICommand command){
        command.getHelp();
    }


}
