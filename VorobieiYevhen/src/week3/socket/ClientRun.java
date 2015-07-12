package week3.socket;

import utils.IOUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;



public class ClientRun {
    public static void main(String[] args) throws IOException {


            Socket socket = new Socket("192.168.1.45", 9999); //"127.0.0.1" or "localhost"
            PrintWriter pw = null;
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));


            String response = IOUtils.readAll(socket.getInputStream());
            System.out.println(response);

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
