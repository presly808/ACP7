package ua.artcode.week2;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by pikolo on 05.07.15.
 */
public class IOUtils {

    public static void save(String source, String path) throws FileNotFoundException{
        OutputStream os = null;
        try {
            os = new FileOutputStream(path);
            byte[] arr = source.getBytes();
            os.write(arr);
            os.close();
        } catch (FileNotFoundException e) {
            throw e;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (os != null){
                os.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static String readAll(InputStream inputStream) {
        StringBuilder sb = new StringBuilder();

        BufferedReader bf = new BufferedReader ( new InputStreamReader(inputStream));

        String line = null;
        try {
            while ((line = bf.readLine()) != null){
                sb.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return sb.toString();

    }

     public static void writeAll(OutputStream outputStream) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()){

            String input = sc.nextLine();

        }

    }

}
