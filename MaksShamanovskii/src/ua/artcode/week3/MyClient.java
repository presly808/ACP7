package ua.artcode.week3;

import ua.artcode.week2.io.IOUtils;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class MyClient {
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        Socket socket = new Socket("192.168.1.45", 9999);
        PrintWriter pw = new PrintWriter(socket.getOutputStream());

        while(true) {
            String serverResponse = IOUtils.readAll(socket.getInputStream());
            System.out.println(serverResponse);
            String ats = s.nextLine();
            pw.write(ats);
            pw.flush();
        }

    }
}
