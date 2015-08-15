package ua.artcode.week4.simple_socket_chat;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

import static java.nio.charset.StandardCharsets.UTF_8;

/**
 * Created by dasha on 29.07.15.
 */
public class ChatServer {
    ArrayList<String> history = new ArrayList<>();
    private final String EOF = "EOF";


    private ServerSocket serverSocket;
    private Socket clientSocket;
    private InputStream is;
    private OutputStream os;


    public void run() throws IOException {
        serverSocket = new ServerSocket(1313);
        clientSocket = serverSocket.accept();

        is = clientSocket.getInputStream();
        os = clientSocket.getOutputStream();

        Scanner scan = new Scanner(System.in);

        sendMessage("Welcome to chat! Please type your message: ");

        String resp;
        while ((resp = readMessage()) != null) {
            System.out.println(resp);
            sendMessage(scan.nextLine());

        }


    }

    private void sendMessage(String text) throws IOException {
        PrintWriter writer = new PrintWriter(os, true);
        writer.println("Server: " + text);
        history.add("Server: " + text);


    }

    private String readMessage() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is, UTF_8));
        String message = reader.readLine();
        history.add(message);
        return message;

    }
}
