package ua.artcode.week3;

import ua.artcode.IOUtils;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Daryna on 12-Jul-15.
 * req "login=Serhii, pass=1234"
 * res "1111111111"
 */
public class ServerRun {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(9999);

        System.out.println(ss.getLocalSocketAddress());
        System.out.println(ss.getInetAddress());

        while(true){
            Socket client = ss.accept();

            String input = IOUtils.readAll(client.getInputStream());
            String info = String.format("Hello server");
            System.out.println(info);
        }
    }
}
