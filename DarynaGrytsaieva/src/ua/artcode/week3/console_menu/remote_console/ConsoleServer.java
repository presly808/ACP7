package ua.artcode.week3.console_menu.remote_console;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by Daryna on 20-Jul-15.
 */
public class ConsoleServer {
    private Set<RemoteUser> userSet = new TreeSet();

    public void start() throws IOException {
        ServerSocket ss = new ServerSocket(1212);

        Socket client = ss.accept();

        PrintWriter out = new PrintWriter(client.getOutputStream(), true);
        BufferedReader in =
                new BufferedReader(
                        new InputStreamReader(client.getInputStream()));

        String info = String.format("Hello from server\n,Menu\n%s", prepareMenuItems());

        sendToClient(out, info);

        String req;
        while ((req = in.readLine()) != null) {
            // register.login=Andrey,pass=1234

            String[] commandNumAndData = req.trim().split("\\.");
            String command = commandNumAndData[0];


            if ("register".equalsIgnoreCase(command)) {
                String data = commandNumAndData[1];
                String[] loginAndPass = data.split(",");
                String login = loginAndPass[0].split("=")[1];
                String pass = loginAndPass[1].split("=")[1];

                RemoteUser remoteUser = new RemoteUser(
                        client.getInetAddress().toString(), login, pass);

                if (!userSet.add(remoteUser)) {
                    sendToClient(out, "login already exists");
                } else {
                    sendToClient(out, "Successful registration");
                }


            } else if ("user-list".equalsIgnoreCase(command)) {
                String res = "";
                for (RemoteUser user : userSet) {
                    res += user + "\n";
                }
                sendToClient(out, res);
            } else if ("command-list".equalsIgnoreCase(command)) {
                RemoteCommandConsole remoteCommandConsole = new RemoteCommandConsole(client);

            }

        }

    }

    private void sendToClient(PrintWriter out, String response) {
        out.println(response + "\nEOF");
    }

    private String prepareMenuItems() {

        return "1.register\n2.user-list\n3.command-list";
    }


}
