package ua.artcode.week4.simple_socket_chat;

import java.io.IOException;

/**
 * Created by dasha on 29.07.15.
 */
public class RunServer {
    public static void main(String[] args) throws IOException {

        ChatServer server = new ChatServer();
        server.run();
    }
}
