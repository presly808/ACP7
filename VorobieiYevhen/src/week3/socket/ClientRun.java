package week3.socket;

import utils.IOUtils;

import java.io.*;
import java.net.Socket;



public class ClientRun {
    public static void main(String[] args) throws IOException {


            Socket socket = new Socket("localhost", 9999); //"127.0.0.1" or "192.168.1.45"
            PrintWriter pw = null;
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            /*String response = IOUtils.readAll(socket.getInputStream()); // we code our server info in writeUTF
            System.out.println(response);*/                                // and try to read it with BufferedReader

            DataInputStream dis = new DataInputStream(socket.getInputStream()); // instead we should read it with DataInputStream
            System.out.println(dis.readUTF());


            try {
            String answer = bufferedReader.readLine();
            pw.println(answer);
                pw.flush();

        }catch (IOException e) {

            e.printStackTrace();
        } finally {
            try {
                if(pw != null)
                    pw.close();
                if(bufferedReader != null)
                    bufferedReader.close();
                if(socket != null)
                    socket.close();

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        String newResponse = IOUtils.readAll(socket.getInputStream());
        System.out.println(newResponse);
        socket.close();
    }


}
