package ua.artcode.utils.io;

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

        String res = "";
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


}
