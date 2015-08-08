package week4.homeWorkWeek4.myChat.model;

import java.io.IOException;
import java.net.Socket;

/**
 * Created by Пользователь on 22.07.15.
 */
public class Client {

    private int port=8889;


    public Client() {
        try {
            Socket socket = new Socket("192.168.1.241",port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
