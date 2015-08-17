package week4.thread.asynchro_chat;

import java.io.IOException;

public class ServerRun {
    public static void main(String[] args) throws IOException {
        new Server().start();
    }
}
