package week3.remote_java_console_commander;

import utils.IOUtils;

import java.io.*;
import java.net.Socket;


public class ClientRun {
    public static void main(String[] args) throws IOException {


            Socket socket = new Socket("localhost", 9999); //"127.0.0.1" or "192.168.1.45"

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));


        DataInputStream dis = new DataInputStream(socket.getInputStream()); // instead we should read it with DataInputStream
        System.out.println(dis.readUTF());
        PrintWriter pw = new PrintWriter(socket.getOutputStream());
            String answer = bufferedReader.readLine();
            pw.println(answer);
                pw.flush();

    }


}
