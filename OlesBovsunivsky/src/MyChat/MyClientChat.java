package MyChat;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class MyClientChat {

    private static String ipAdress = "127.0.0.1";
    private static int port = 8888;


    public static void main(String[] args) {
        try {
            Socket socket = new Socket(ipAdress, port);

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            Scanner scanner = new Scanner(System.in);

            System.out.println("Write nick -> " + scanner.nextLine());
            String str = "";

            while (!str.equals("exit")) {
                str = scanner.nextLine();
                System.out.println(str);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

   private class Resender {
       public boolean stoped;

       public void setStoped() {
           stoped = true;
       }
       public void run(){
           while (!stoped){
             ////  String str = new BufferedReader()
           }
       }

   }
}
