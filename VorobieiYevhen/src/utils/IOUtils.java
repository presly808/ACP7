package utils;

import java.io.*;

public class IOUtils {

    public static String readAll (InputStream inputStream) {
        StringBuilder sb = new StringBuilder(); //Immutable
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        String line = null;

        try {
            while ((line = bufferedReader.readLine()) != null) {
                sb.append(line);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
    public static void readFullyByBytes (InputStream is) {
        int oneByte;
        try {
            while ((oneByte = is.read()) != -1) {
                System.out.print((char) oneByte);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static boolean copy(InputStream in, OutputStream out) {


        return false;

    }

}
