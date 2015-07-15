package ua.artcode.week2;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Олександр on 10.07.2015.
 */
public class Checker {
    private Set<String> commands = new HashSet<String>();

    private void init(){
        commands.add("help");
        commands.add("cd");
        commands.add("find");
        commands.add("dir");
        commands.add("type");
        commands.add("del");
        commands.add("rd");
        commands.add("mkdir");
        commands.add("tree");
        commands.add("copy");
        commands.add("fc");
    }
        Checker(){
            init();
        }

      public boolean isCommandExist(String command){
        return commands.contains(command);
    }

}


