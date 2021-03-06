package ua.artcode.io;

import java.io.*;
import java.util.Scanner;

/**
 * Created by serhii on 05.07.15.
 */
public class IOUtils {

    public static void save(String source, String path) throws FileNotFoundException {
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
                if (os != null) {
                    os.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static String readAllS(InputStream inputStream) {
        StringBuilder sb = new StringBuilder(); // Immutable

        Scanner scanner = new Scanner(inputStream);

        while (scanner.hasNextLine()) {
            sb.append(scanner.nextLine());
        }

        return sb.toString();
    }

    public static String readAll(InputStream inputStream) {
        StringBuilder sb = new StringBuilder(); // Immutable

        BufferedReader bf = new BufferedReader(
                new InputStreamReader(inputStream));

        String line = null;
        try {
            while ((line = bf.readLine()) != null) {
                sb.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return sb.toString();
    }

    public static void sendData(String src, OutputStream os) throws IOException {
        Writer wr = new BufferedWriter(new OutputStreamWriter(os));
        wr.write(src);
        wr.flush();
    }

    public static void sendDataPure(String src, OutputStream os) throws IOException {
        os.write(src.getBytes());
        os.flush();
    }

    public static String readPure(InputStream is) throws IOException {
        StringBuilder sb = new StringBuilder();
        int read = 0;

        while ((read = is.read()) != -1){
            sb.append((char)read);
        }

        return sb.toString();
    }


}
