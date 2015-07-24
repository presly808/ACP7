package ua.artcode.week4.chat;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created by tokar on 23.07.2015.
 */
public class ChatClient {
    public static void main(String[] args) {
        int serverPort = 8888;
        String address = "192.168.1.200";
        try {
            InetAddress ip = InetAddress.getByName(address);

            System.out.println("Any of you heard of a socket with IP address "
                    + address +
                    " and port "
                    + serverPort + "?");

            Socket socket = new Socket(ip, serverPort);

            System.out.println(" I have just got hold!");
            InputStream sin = socket.getInputStream();
            OutputStream sout = socket.getOutputStream();

            DataInputStream in = new DataInputStream(sin);
            DataOutputStream out = new DataOutputStream(sout);

            BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));

            String line = null;
            System.out.println("Type in something and press enter. Will send it to the server.");
            System.out.println();

            while (true) {
                line = keyboard.readLine(); // ждем пока пользователь введет что-то и нажмет кнопку Enter.
                System.out.println("Sending this line to the server...");

                out.writeUTF(line); // отсылаем введенную строку текста серверу.
                out.flush();
                line = in.readUTF();
                System.out.println("Sent: " + line);
                System.out.println(" Enter more lines.");
                System.out.println();


            }
        } catch (Exception x) {
            x.printStackTrace();
        }


    }
}
