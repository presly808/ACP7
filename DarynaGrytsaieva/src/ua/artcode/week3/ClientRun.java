package ua.artcode.week3;

import ua.artcode.IOUtils;

import java.io.IOException;
import java.net.Socket;

/**
 * Created by Daryna on 12-Jul-15.
 */
public class ClientRun {
    public static void main(String[] args) throws IOException {
        //Sergii 192.168.1.45
        Socket socket = new Socket("192.168.1.45", 9999);//"localhost" 127.0.0.1
        String serverResponse = IOUtils.readAll(socket.getInputStream());
        System.out.println(serverResponse);



    }
}

