package client_two;

import client_socket.IOUtils;

import java.io.*;
import java.net.Socket;


public class Client_Two {
    public static void main(String[] args) throws IOException {

        Socket socket = new Socket("192.168.1.45", 9999);

        BufferedWriter bf = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));





        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String serverresponse = IOUtils.readAll(socket.getInputStream());
        System.out.println(serverresponse);


    }


}
