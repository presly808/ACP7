package ua.artcode.week3;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * Created by Олександр on 12.07.2015.
 */
public class ClientRun {

    public static void main(String[] args) throws IOException{

        Socket socket = new Socket("192.168.1.45",9999);//192.168.1.15
        String serverResponse = readAll(socket.getInputStream());
        System.out.println(serverResponse);



    }



    public static String readAll(InputStream inputstream) {

        StringBuilder sb = new StringBuilder();
        BufferedReader bf = new BufferedReader(
                new InputStreamReader(inputstream));

        String line = null;

        try{
            while ((line = bf.readLine()) != null){
                sb.append(line);
            }
        } catch (IOException e){
            e.printStackTrace();
        }
        return sb.toString();
    }


}
