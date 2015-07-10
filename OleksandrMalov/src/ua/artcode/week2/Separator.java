package ua.artcode.week2;

import javax.swing.*;
import java.util.*;


/**
 * Created by Олександр on 10.07.2015.
 */
public class Separator {
    static Scanner scanner = new Scanner(System.in);
    void scanner(){
        System.out.println(":");
    }
    static String inputCommand = scanner.nextLine();
    static String[] words = inputCommand.split(" ");

    private static Set<String> commands = new HashSet<String>();

    private void commands(){
         init();
    }
     void init(){
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
    private static boolean findCommand(String[] words, HashSet<String> commands){
    for(String x : commands) {
        for (int i = 0; i < words.length; i++)
        if (words[i] == x)
            System.out.println(1);
            return true;
    }
        System.out.println(2);
    return false;

    }

    public static void main(String[] args) {
        System.out.println(scanner.nextLine());
        commands.;
        findCommand(words, (HashSet<String>) commands);

    }


}









