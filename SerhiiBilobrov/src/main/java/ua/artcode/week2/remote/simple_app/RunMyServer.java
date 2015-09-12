package ua.artcode.week2.remote.simple_app;

import java.io.IOException;

/**
 * Created by serhii on 12.07.15.
 */
public class RunMyServer {

    public static void main(String[] args) throws IOException {
        MyServer myServer = new MyServer();

        myServer.start();
    }
}
