package MyServer;

import javafx.scene.input.DataFormat;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;


/**
 * Created by Legion on 20.07.2015.
 */
public class MyServer {
    private final static int port = 7777;

        public static void main (String[]args){


            try {

                ServerSocket serverSocket = new ServerSocket(port);
                Socket socket = serverSocket.accept();


                DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
                DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

                String line = null;

                while (true) {

                    //line = dataInputStream.readUTF();
                    line = dataInputStream.readUTF();
                    String[] idOfInputUser = line.split("idU");
                    //  System.out.println("Message of user -> "+idOfInputUser[0]+" ID user "+idOfInputUser[1]+" "+socket.getInetAddress()+" "+socket.getLocalAddress());

                    dataOutputStream.writeUTF("Your message send " + new Date());
                    dataOutputStream.flush();

                }

            } catch (IOException e) {
                e.printStackTrace();
            }

        }

}

