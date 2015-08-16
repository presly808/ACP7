package ua.artcode.week4.simple_socket_chat;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

import static java.nio.charset.StandardCharsets.UTF_8;

/**
 * Created by dasha on 29.07.15.
 */
public class ChatClient {
    private final String EOF = "EOF";


    private Socket clientSocket;
    private InputStream is;
    private OutputStream os;


    public void run() throws IOException {
        clientSocket = new Socket("localhost", 1313);

        is = clientSocket.getInputStream();
        os = clientSocket.getOutputStream();

        Scanner scan = new Scanner(System.in);

        System.out.println(readMessage());

        String resp;
        while ((resp = scan.nextLine()) != null) {
            sendMessage(resp);
            System.out.println(readMessage());

        }


    }

    private void sendMessage(String text) throws IOException {
        PrintWriter writer = new PrintWriter(os, true);
        writer.println("Client: " + text);


    }

    private String readMessage() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is, UTF_8));
        return reader.readLine();

    }
}
