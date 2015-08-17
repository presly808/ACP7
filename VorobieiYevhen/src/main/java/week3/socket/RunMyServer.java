package week3.socket;

import java.io.IOException;

/**
 * Created by Джек on 14.07.2015.
 */
public class RunMyServer {

    public static void main(String[] args) throws IOException {
        MyServer myServer = new MyServer();

        myServer.start();
    }
}
