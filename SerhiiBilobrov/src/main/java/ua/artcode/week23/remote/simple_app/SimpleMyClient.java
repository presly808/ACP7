package ua.artcode.week23.remote.simple_app;

import ua.artcode.utils.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by serhii on 12.07.15.
 */
public class SimpleMyClient {

    public static void main(String[] args) throws IOException {
        Scanner console = new Scanner(System.in);

        Socket socket = new Socket("127.0.0.1",9999);// 127.0.0.1
        PrintWriter pw = new PrintWriter(socket.getOutputStream());
        InputStream is = socket.getInputStream();

        while (true){
            String serverResponse = IOUtils.readAllS(is);
            System.out.println(serverResponse);
            String command = console.nextLine();
            pw.println(command);
            pw.flush();

            String operationResult = IOUtils.readAllS(is);
            System.out.println(operationResult);

        }

    }
}
