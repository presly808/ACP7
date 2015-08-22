package ua.artcode.ClassWork.Week_3.adapter.remote.simple_app;

import java.io.IOException;

public class RunMyServer {

    public static void main(String[] args) throws IOException {
        MyServer myServer = new MyServer();

        myServer.start();
    }
}
