package ua.artcode.week3.remote_server;

import ua.artcode.utils.IOUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by boris on 7/12/15.
 */
public class ClientRun {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("192.168.1.45", 9999);
            String menu = IOUtils.readAll(socket.getInputStream());
//            PrintWriter pw = new PrintWriter(socket.getOutputStream());
            System.out.println(menu);
//            pw.println(getRegister("user1", "12345"));
//            pw.flush();
//            String allUsers = IOUtils.readAll(socket.getInputStream());
//            System.out.printf(allUsers);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getRegister(String user, String pass) {
        return String.format("register.login=%s,pass=%s", user, pass);
    }

}
