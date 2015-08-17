package ua.artcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by Daryna on 12-Jul-15.
 */
public class IOUtils {
    public static String readAll(InputStream inputStream){
        StringBuilder sb = new StringBuilder();
        BufferedReader bf = new BufferedReader(new InputStreamReader(inputStream));
        String line = null;
        try {
            while((line = bf.readLine())!=null){
                sb.append(line);
                
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
}
