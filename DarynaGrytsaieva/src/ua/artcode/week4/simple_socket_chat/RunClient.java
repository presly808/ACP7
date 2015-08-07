package ua.artcode.week4.simple_socket_chat;

import java.io.IOException;

/**
 * Created by dasha on 29.07.15.
 */
public class RunClient {
    public static void main(String[] args) throws IOException {
        ChatClient client = new ChatClient();
        client.run();
    }
}
