package ua.artcode.HomeWork.Week_4.Chat_P2P;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.Scanner;

/**
 * Created by HOME on 21.07.2015.
 */
public class TestServer {

    public static void main(String[] args) throws IOException, InterruptedException {
        ServerSocket ss = new ServerSocket(9999);
        Server server = new Server();
        Socket client = ss.accept();
        int count =0;
        boolean connection = true;
        String mes = null;
        Scanner scanner = new Scanner(System.in);
        String nameClient = null;

        nameClient=server.readFromUser(client.getInputStream());
        System.out.println("Client -"+nameClient);

        server.sendToUser(server.connectionInfo(),client.getOutputStream());

/*
            nameClient=server.readFromUser(client.getInputStream());
            System.out.println("Client ="+nameClient);

            System.out.println("Enter mess");
            mes=scanner.nextLine();
            server.sendToUser(mes,client.getOutputStream());

            String serverAnsver = server.readFromUser(client.getInputStream());
            System.out.println(serverAnsver);

*/
        System.out.println("Finish");
    }
}
