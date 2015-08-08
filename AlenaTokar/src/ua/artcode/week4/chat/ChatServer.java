package ua.artcode.week4.chat;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by tokar on 22.07.2015.
 */
public class ChatServer {

    public static void main(String[] args) {
        int port=8888;
        try {
            // он умеет заставлять программу ждать подключений от клиентов.
            // Когда вы его создаете, нужно указывать порт, с которым он будет работать, и вызвать его метод accept().
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Waiting for a client");

            //Этот метод заставляет программу ждать подключений по указанному порту.
            // Исполнение программы зависает в этом месте, пока клиент не подключится.
            Socket socket =serverSocket.accept(); //Listens for a connection to be made to this socket and accepts it.blocks!
            System.out.println("Got client...");
            System.out.println();

            // socket streams
            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream= socket.getOutputStream();

            //convert streams
            //A data input(out) stream lets an application read primitive Java data types from an underlying input stream
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            DataOutputStream dataOutputStream =new DataOutputStream(outputStream);

            String line = null;

            while(true){
                line =dataInputStream.readUTF(); //return     a Unicode string.
                System.out.println("Message from client  ---"+ line);
                System.out.println("I'm sending it back...");
                dataOutputStream.writeUTF(line); // !!!! same text
                dataOutputStream.flush();
                System.out.println("Waiting for the next line...");
                System.out.println();

            }



        } catch (IOException e) {
            e.printStackTrace();

        }


    }
}




