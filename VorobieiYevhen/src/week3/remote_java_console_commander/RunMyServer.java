package week3.remote_java_console_commander;

import week3.socket.MyServer;

import java.io.IOException;

/**
 * Created by Джек on 14.07.2015.
 */
public class RunMyServer {

    public static void main(String[] args) throws IOException {
        week3.socket.MyServer myServer = new MyServer();

        myServer.start();
    }
}
