package ua.artcode.HomeWork.Week_4.Chat_P2P;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Date;
import java.util.Scanner;

/**
 * Created by HOME on 21.07.2015.
 */
class Client implements IClient {
    private String name;
    private String ip;
    Socket socket = new Socket();
    public String getName() {
        return name;
    }

    public String getIp() {
        return ip;
    }

    public Client(Socket socket) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your name - ");
        this.name = sc.nextLine().toString();
        this.ip = socket.getInetAddress().toString();
    }

    @Override
    public void showInfo() { System.out.println ("Name - "+ getName()+"; IP - "+getIp()+"/;");
    }


    @Override
    public String readMesFromServer(InputStream is) throws IOException {
        StringBuilder sb = new StringBuilder();
        int read = 0;
        while ((read = is.read()) != -1) {
            sb.append((char) read);
        }
        return sb.toString();
    }

    @Override
    public void writeMesOnServer(String line, OutputStream outputStream)throws IOException{
        outputStream.write(line.getBytes());
        outputStream.flush();
        outputStream.close();
    }
}
