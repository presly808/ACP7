package ua.artcode.week3;

import ua.artcode.week2.fileHelper.IOUtils;

import java.io.*;
import java.net.Socket;

/**
 * Created by tokar on 12.07.2015.
 */
public class ClientRun {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("192.168.1.45", 9999);//127.0.0.1 "Localhost",9999

        while (true) {
            String serverResponce = IOUtils.readAll(socket.getInputStream());
            System.out.println(serverResponce);
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            bufferedWriter.flush();
            String serverResponce2 = IOUtils.readAll(socket.getInputStream());
            System.out.println(serverResponce2);



        }
    }
}
