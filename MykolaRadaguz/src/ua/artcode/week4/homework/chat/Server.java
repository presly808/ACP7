package ua.artcode.week4.homework.chat;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by pikolo on 23.07.15.
 */
public class Server {

    static ServerSocket socket;
    public static List<ConnectedClient> clients = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        socket = new ServerSocket(2000);

        while (true) {
            ConnectedClient client = new ConnectedClient(socket.accept());
            clients.add(client);
            client.start();
        }
    }

}
