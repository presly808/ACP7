package ua.artcode.week3;

import ua.artcode.week2.fileHelper.IOUtils;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by tokar on 12.07.2015.
 */
public class ClientRun {
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        Socket socket = new Socket("192.168.1.45", 9999);//127.0.0.1 "Localhost",9999
        PrintWriter pw = new PrintWriter(socket.getOutputStream());

        while (true) {
            String serverResponse = IOUtils.readAll(socket.getInputStream());
            System.out.println(serverResponse);
            String forRead =s.nextLine();
            pw.write(forRead);
            pw.flush();







        }



    }
}
