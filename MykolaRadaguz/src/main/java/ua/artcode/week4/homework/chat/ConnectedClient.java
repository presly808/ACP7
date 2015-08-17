package ua.artcode.week4.homework.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by pikolo on 23.07.15.
 */
public class ConnectedClient extends Thread {
    private Socket sock;
    private BufferedReader input;
    private PrintWriter output;
    private Server server;

    public ConnectedClient(Socket s) throws IOException {
        sock = s;
        System.out.println("New user connected from " + s.getInetAddress().toString());
        input = new BufferedReader(new InputStreamReader(sock.getInputStream()));
        output = new PrintWriter(sock.getOutputStream());
    }

    @Override
    public void run() {
        try {
            while (sock.isConnected()) {
                String received = input.readLine();
                for (ConnectedClient c : server.clients) {
                    c.send(received);
                }
            }
        } catch (IOException e) {
            System.out.println(e.toString());
        } finally {
            System.out.println("User disconnected from " + sock.getInetAddress().toString());
        }
    }

    public void send(String s) throws IOException {
        output.println(s);
        output.flush();
    }
}
