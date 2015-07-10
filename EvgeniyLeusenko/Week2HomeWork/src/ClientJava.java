import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created by Пользователь on 10.07.2015.
 */
public class ClientJava {
    public static void main(String[] args) {
        int serverPort=6666;
        String address="127.0.0.1";
        FileHelper fh = new FileHelper();//for menu
        fh.menu();
        try {
            InetAddress ipAddress = InetAddress.getByName(address);
            Socket socket = new Socket(ipAddress, serverPort);
            InputStream sin = socket.getInputStream();
            OutputStream sout = socket.getOutputStream();
            DataInputStream in = new DataInputStream(sin);
            DataOutputStream out = new DataOutputStream(sout);
            BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
            String line = null;
            System.out.println("Enter the command");
            System.out.println();
            while (true) {
                line = keyboard.readLine();
                System.out.println("Sending this line to the server...");
                out.writeUTF(line);
                out.flush();
                line = in.readUTF();
                System.out.println("The server sent me this : " + line);
                System.out.println("Add command");
                System.out.println();
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
