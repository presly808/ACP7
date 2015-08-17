package ua.artcode.HomeWork.Week_4.Chat_P2P;


import java.io.IOException;
import java.net.Socket;
import java.util.Date;
import java.util.Scanner;

/**
 * Created by HOME on 21.07.2015.
 */
public class TestClient {


    public static void main(String[] args) throws IOException {
        Socket cs = new Socket("192.168.0.100", 9999);
        boolean connection = true;
        int count = 0;
        String mes = null;
        Scanner scanner = new Scanner(System.in);

        Client client1 = new Client(cs);
        client1.showInfo();

        client1.writeMesOnServer(client1.getName(), cs.getOutputStream());

            String serverAnsver = client1.readMesFromServer(cs.getInputStream());
            System.out.println(serverAnsver);
/*
            System.out.println("Enter mess");
            mes = scanner.nextLine();
            client1.writeMesOnServer(mes, cs.getOutputStream());
            mes = null;
*/
System.out.println("Finish");
    }
}
