package ua.artcode.week23.remote.sample;

import ua.artcode.utils.io.IOUtils;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 * Created by serhii on 12.07.15.
 */
public class ServerRun {

    public static void main(String[] args) throws IOException {

        ServerSocket ss = new ServerSocket(9999);

        while(true){
            Socket client = ss.accept();

            String info = String.format("Hello from server, your inet add %s, time %tc\n",
                    client.getInetAddress().toString(), new Date());

            // String input = IOUtils.readAll(client.getInputStream());


            System.out.println(info);

            IOUtils.sendDataPure(info, client.getOutputStream());

        }



    }
}
