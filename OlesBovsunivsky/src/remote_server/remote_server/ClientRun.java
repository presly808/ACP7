package remote_server.remote_server;

import MyIOAp.IOAp;
import java.io.IOException;
import java.net.Socket;

/**
 * Created by Legion on 12.07.2015.
 */
public class ClientRun {
    public static void main(String[] args) throws IOException {

        Socket socket = new Socket("192.168.1.45", 9999);
        
        String serverResponse = IOAp.readdAll(socket.getInputStream());

        System.out.println(serverResponse);
    }
}
