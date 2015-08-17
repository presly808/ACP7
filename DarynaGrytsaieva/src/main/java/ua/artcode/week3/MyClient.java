package ua.artcode.week3;

import ua.artcode.IOUtils;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by Daryna on 12-Jul-15.
 */
public class MyClient {
    public static void main(String[] args) throws IOException {
        //Sergii 192.168.1.45
        Socket socket = new Socket("192.168.1.45", 9999);//"localhost" 127.0.0.1
        Scanner scan = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(socket.getOutputStream());

        while (true) {
            String serverResponse = IOUtils.readAll(socket.getInputStream());
            System.out.println(serverResponse);
            String clientRequest = scan.nextLine();
            pw.println(clientRequest);
            pw.flush();
        }

    }
}
