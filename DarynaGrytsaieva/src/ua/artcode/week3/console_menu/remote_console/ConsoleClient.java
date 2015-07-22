package ua.artcode.week3.console_menu.remote_console;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by Daryna on 20-Jul-15.
 */
public class ConsoleClient {

    public static final String END_OF_FILE = "EOF";

    public void start() throws IOException {

        Scanner console = new Scanner(System.in);

        Socket socket = new Socket("localhost", 1212);// 127.0.0.1

        PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);

        InputStream in = socket.getInputStream();

        System.out.println(readString(in));

        String command;
        while ((command = console.nextLine()) != null) {
            pw.println(command);

            System.out.println(readString(in));
        }

    }

    private String readString(InputStream in) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br =
                new BufferedReader(
                        new InputStreamReader(in));
        String line;
        while((line = br.readLine()) != null) {
            if (line.equals(END_OF_FILE)) {
                return sb.toString();
            }
            sb.append(line).append("\n");
        }
        return sb.toString();
    }

}
