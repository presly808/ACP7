package ua.artcode.week4.nonblocking_chat;

import java.io.IOException;

/**
 * Created by dasha on 04.08.15.
 */
public class Test {
    public static void main(String[] args) throws IOException, InterruptedException {
        NonblockingClient client = new NonblockingClient();
        client.run();
    }
}
