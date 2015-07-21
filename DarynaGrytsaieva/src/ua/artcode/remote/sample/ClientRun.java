package ua.artcode.remote.sample;

import ua.artcode.utils.io.IOUtils;

import java.io.IOException;
import java.net.Socket;


public class ClientRun {

    public static void main(String[] args) throws IOException {
        // 192.168.1.45
        Socket socket = new Socket("127.0.0.1",9999);// 127.0.0.1

        String serverResponse = IOUtils.readPure(socket.getInputStream());

        System.out.println(serverResponse);

    }

}
