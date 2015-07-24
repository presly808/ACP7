package ua.artcode.week3.console_menu.remote_console;

import java.io.IOException;

/**
 * Created by Daryna on 20-Jul-15.
 */
public class RunServer {
    public static void main(String[] args) {

        ConsoleServer cs = new ConsoleServer();
        try {
            cs.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
