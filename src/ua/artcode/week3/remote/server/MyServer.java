package ua.artcode.week3.remote.server;

import ua.artcode.utils.io.IOUtils;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

/**
 * Created by serhii on 12.07.15.
 */
public class MyServer {


    private Set<RemoteUser> userSet = new TreeSet<>();


    public void start() throws IOException {
        ServerSocket ss = new ServerSocket(9999);

        Socket client = ss.accept();
        DataOutputStream pw = new DataOutputStream(client.getOutputStream());
        Scanner sc =  new Scanner(client.getInputStream());


        while (true) {
            String info = String.format("Hello from server\n,Menu\n%s", prepareMenuItems());

            pw.writeUTF(info);
            pw.flush();
            //pw.close();

            // register.login=Andrey,pass=1234
            String req = sc.nextLine();

            String[] commandNumAndData = req.trim().split(".");
            String command = commandNumAndData[0];
            String data = commandNumAndData[1];


            if ("register".equalsIgnoreCase(command)) {
                String[] loginAndPass = data.split(",");
                String login = loginAndPass[0].split("=")[1];
                String pass = loginAndPass[1].split("=")[1];

                RemoteUser remoteUser = new RemoteUser(
                        client.getInetAddress().toString(), login, pass);


                if (!userSet.add(remoteUser)) {
                    pw.writeUTF("login already exists");
                } else {
                    pw.writeUTF("Success registration");
                }
                pw.flush();


            } else if("user-list".equalsIgnoreCase(command)) {
                String res = "";
                for (RemoteUser user : userSet) {
                    res += user + "\n";
                }
                pw.writeUTF(res);
                pw.flush();
            } else {

            }


            System.out.println(info);

        }

    }

    private String prepareMenuItems() {
        return "1.Register\n2.user-list";
    }


}
