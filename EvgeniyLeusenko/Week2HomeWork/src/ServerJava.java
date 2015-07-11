import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Пользователь on 10.07.2015.
 */
public class ServerJava {

    public static void main(String[] args) {
        int port=6666;
        try {
            ServerSocket ss=new ServerSocket(port);
            System.out.println("Waiting for a client");
            Socket socket = ss.accept();
            System.out.println("Got a client ");
            InputStream cin=socket.getInputStream();
            OutputStream cout=socket.getOutputStream();
            DataInputStream in = new DataInputStream(cin);
            DataOutputStream out = new DataOutputStream(cout);
            String line = null;
            while(true) {
                line = in.readUTF();
                System.out.println("The client sent me " + line);
                FileHelperController fileHelperController=new FileHelperController();
                String command=line;
                String answer=new String();
                answer=fileHelperController.MainForSocket(command);
                out.writeUTF(answer);
                out.writeUTF("Your wish is done, your majesty"); // отсылаем клиенту обратно ту самую строку текста.
                out.flush(); // заставляем поток закончить передачу данных.

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
