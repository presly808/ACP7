package ua.artcode.week3.remote.server;

import ua.artcode.utils.io.IOUtils;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 * Created by serhii on 12.07.15.
 */
public class SimpleServerRunTest {

    public static void main(String[] args) throws IOException {

        ServerSocket ss = new ServerSocket(9999);
        System.out.println(ss.getLocalSocketAddress());
        System.out.println(ss.getInetAddress());


        while(true){
            Socket client = ss.accept();

            // String input = IOUtils.readAll(client.getInputStream());


            String info = String.format("Hello from server, your inet add %s, time %tc",
                    client.getInetAddress().toString(), new Date());
            System.out.println(info);
            PrintWriter pw = new PrintWriter(client.getOutputStream());
            pw.println(info);
            pw.flush();
            pw.close();

        }



    }
}
