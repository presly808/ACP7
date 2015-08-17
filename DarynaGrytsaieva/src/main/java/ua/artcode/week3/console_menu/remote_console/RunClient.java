package ua.artcode.week3.console_menu.remote_console;

import java.io.IOException;

/**
 * Created by Daryna on 20-Jul-15.
 */
public class RunClient {
    public static void main(String[] args) {
        ConsoleClient cc = new ConsoleClient();
        try {
            cc.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
