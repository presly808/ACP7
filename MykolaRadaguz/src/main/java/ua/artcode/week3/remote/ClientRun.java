package ua.artcode.week3.remote;

import ua.artcode.week2.IOUtils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.Socket;

/**
 * Created by pikolo on 12.07.15.
 */
public class ClientRun {

    public static void main(String[] args) throws IOException{

        Socket socket = new Socket("192.168.1.45",9999);//192.168.1.45 = IP adress Sergey

            String serverResponse = IOUtils.readAll(socket.getInputStream());
            System.out.println(serverResponse);


    }

}
