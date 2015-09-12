package ua.artcode.week2.remote.sample;

import ua.artcode.utils.io.IOUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.nio.Buffer;


public class ClientRun {

    public static void main(String[] args) throws IOException {
        // 192.168.1.45
        Socket socket = new Socket("127.0.0.1",9999);// 127.0.0.1

        String serverResponse = IOUtils.readPure(socket.getInputStream());

        System.out.println(serverResponse);

    }

}
