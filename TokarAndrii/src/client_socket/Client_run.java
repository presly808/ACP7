package client_socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;


public class Client_run {
    public static void main(String[] args) throws IOException {

        Socket socket = new Socket("192.168.1.45", 9999);//192.168.1.45 if config

        BufferedReader bf = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String serverresponse = IOUtils.readAll(socket.getInputStream());
        System.out.println(serverresponse);

    }


}
