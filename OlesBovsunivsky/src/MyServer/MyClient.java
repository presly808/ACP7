package MyServer;

import java.io.*;

import java.net.Socket;

/**
 * Created by Legion on 20.07.2015.
 */
public class MyClient {
    private final static int serverPort = 7777;
    private final static String serverAddress = "127.0.0.1";
    private final static int clientId = 1;
    public static void main(String[] args) {
        try {
            Socket socket = new Socket(serverAddress,serverPort);

            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());

            BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));

            String line = null;

            while (true){
                line = keyboard.readLine();
                outputStream.writeUTF(line+"idU"+clientId);
                System.out.println(dataInputStream.readUTF() );
                outputStream.flush();


            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
