package ua.artcode.week9.http;

import ua.artcode.utils.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by serhii on 05.09.15.
 */
public class TestHttpRequest {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("art-code.com.ua",80);
        PrintWriter pw = new PrintWriter(socket.getOutputStream());
        pw.println("GET / HTTP/1.1\nHost: art-code.com.ua\nConnection: keep-alive\n");
        pw.flush();


        readStream(socket.getInputStream());






    }

    private static void readStream(InputStream inputStream) throws IOException {
        Scanner sc = new Scanner(inputStream);

        while(sc.hasNextLine()){
            System.out.println(sc.nextLine());
        }
    }
}
